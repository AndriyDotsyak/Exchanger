package com.exchanger.exchange.exchange

import com.exchanger.domain.extension.formatInputCurrency
import com.exchanger.domain.extension.parseDouble
import com.exchanger.domain.use_case.balance.get_balances.GetBalancesUseCase
import com.exchanger.domain.use_case.exchange.converter.ConvertCurrencyUseCase
import com.exchanger.domain.use_case.exchange.exchange.ExchangeUseCase
import com.exchanger.domain.use_case.exchange.get_exchange_rates.GetExchangeRatesUseCase
import com.exchanger.domain.util.FormatUtil
import com.exchanger.exchange.exchange.mvi.ExchangeEffect
import com.exchanger.exchange.exchange.mvi.ExchangeIntent
import com.exchanger.exchange.exchange.mvi.ExchangeState
import com.exchanger.model.balance.Balance
import com.exchanger.model.exchange.ExchangeRate
import com.exchanger.model.exchange.Rate
import com.exchanger.ui.architecture.BaseViewModel
import com.exchanger.ui.architecture.error_handler.DataError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel @Inject constructor(
    private val getExchangeRatesUseCase: GetExchangeRatesUseCase,
    private val getBalancesUseCase: GetBalancesUseCase,
    private val convertCurrencyUseCase: ConvertCurrencyUseCase,
    private val exchangeUseCase: ExchangeUseCase
) : BaseViewModel<ExchangeState, ExchangeEffect>(), ExchangeIntent {

    init {
        initStateAsync()
        initSubscribes()
    }

    override fun initState(): ExchangeState {
        return ExchangeState()
    }

    private fun initStateAsync() {
        viewModelScope.launch {
            val exchangeRate = getExchangeRatesUseCase()

            updateState {
                copy(
                    exchangeRate = exchangeRate,
                    selectedCurrencySell = exchangeRate.rates[0],
                    selectedCurrencyReceive = exchangeRate.rates[1]
                )
            }
        }
    }

    private fun initSubscribes() = with(viewModelScope) {
        launch { getBalancesUseCase.getStream().collectLatest(::handleBalances) }
        launch { getExchangeRatesUseCase.getStream().collectLatest(::handleExchangeRate) }
        launch { errorStream.collect(::handleError) }
    }

    override fun onChangeAmountSell(amount: String) {
        updateState { copy(amountSell = amount.formatInputCurrency()) }
        updateExchangeAmount()
    }

    override fun onChangeCurrencySell(currency: Rate) {
        updateState { copy(selectedCurrencySell = currency) }
        updateExchangeAmount()
    }

    override fun onChangeCurrencyReceive(currency: Rate) {
        updateState { copy(selectedCurrencyReceive = currency) }
        updateExchangeAmount()
    }

    override fun hideSuccessDialog() {
        updateState { copy(isVisibleSuccessDialog = false) }
    }

    override fun submit() {
        viewModelScope.launch {
            val exchangeResult = exchangeUseCase(
                currencySell = state.value.selectedCurrencySell.currency,
                currencyReceive = state.value.selectedCurrencyReceive.currency,
                amountSell = state.value.amountSell.parseDouble(),
                amountReceive = state.value.amountReceive.parseDouble()
            )

            updateState {
                copy(
                    exchangeResult = exchangeResult,
                    isVisibleSuccessDialog = true
                )
            }
        }
    }

    private fun updateExchangeAmount() {
        viewModelScope.launch {
            val amountReceive = convertCurrencyUseCase(
                rates = state.value.exchangeRate.rates,
                currencySell = state.value.selectedCurrencySell.currency,
                currencyReceive = state.value.selectedCurrencyReceive.currency,
                amount = state.value.amountSell.parseDouble()
            )

            updateState {
                copy(
                    amountReceive = FormatUtil.formatCurrency(amountReceive),
                    isProfitableExchange = amountReceive > 0
                )
            }
        }
    }

    private fun handleBalances(balances: List<Balance>) {
        updateState { copy(balances = balances) }
    }

    private fun handleExchangeRate(exchangeRate: ExchangeRate) {
        updateState {
            copy(exchangeRate = exchangeRate)
        }
    }

    private fun handleError(dataError: DataError) {
        when (dataError) {
            is DataError.Message -> publishEffect(ExchangeEffect.ShowToast(dataError.message))
            is DataError.Resource -> publishEffect(ExchangeEffect.ShowToastResource(dataError.messageId))
        }
    }

}