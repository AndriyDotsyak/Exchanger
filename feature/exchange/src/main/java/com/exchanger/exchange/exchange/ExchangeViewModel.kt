package com.exchanger.exchange.exchange

import com.exchanger.domain.use_case.balance.get_balances.GetBalancesUseCase
import com.exchanger.domain.use_case.exchange.get_exchange_rates.GetExchangeRatesUseCase
import com.exchanger.exchange.exchange.mvi.ExchangeEffect
import com.exchanger.exchange.exchange.mvi.ExchangeIntent
import com.exchanger.exchange.exchange.mvi.ExchangeState
import com.exchanger.model.balance.Balance
import com.exchanger.ui.architecture.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel @Inject constructor(
    private val getExchangeRatesUseCase: GetExchangeRatesUseCase,
    private val getBalancesUseCase: GetBalancesUseCase
) : BaseViewModel<ExchangeState, ExchangeEffect>(), ExchangeIntent {

    init {
        initStateAsync()
    }

    override fun initState(): ExchangeState {
        return ExchangeState()
    }

    private fun initStateAsync() {
        viewModelScope.launch {
            val exchangeRate = getExchangeRatesUseCase()
            val balances = getBalancesUseCase.invoke(exchangeRate.rates)

            updateState {
                copy(
                    exchangeRate = exchangeRate,
                    balances = balances,
                    selectedCurrencySell = balances[0],
                    selectedCurrencyReceive = balances[1]
                )
            }
        }
    }

    override fun onChangeAmountSell(amount: String) {
        updateState { copy(amountSell = amount) }
    }

    override fun onChangeAmountReceive(amount: String) {
        updateState { copy(amountReceive = amount) }
    }

    override fun onChangeCurrencySell(balance: Balance) {
        updateState { copy(selectedCurrencySell = balance) }
    }

    override fun onChangeCurrencyReceive(balance: Balance) {
        updateState { copy(selectedCurrencyReceive = balance) }
    }

    override fun submit() {
        // TODO("Not yet implemented")
    }

}