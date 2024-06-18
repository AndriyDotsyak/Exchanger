package com.exchanger.exchange.exchange

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.exchanger.exchange.exchange.mvi.ExchangeIntent
import com.exchanger.exchange.exchange.mvi.ExchangeState
import com.exchanger.core.resource.R
import com.exchanger.exchange.exchange.component.Balances
import com.exchanger.exchange.exchange.component.ExchangeCurrency
import com.exchanger.ui.component.button.ExchangerButton
import com.exchanger.ui.component.toolbar.Toolbar
import com.exchanger.ui.extension.centerHorizontallyTo
import com.exchanger.ui.navigation.Navigator
import com.exchanger.ui.theme.AppTheme

@Preview
@Composable
private fun ExchangeScreenPreview() {
    ExchangeScreen()
}

@Composable
fun ExchangeScreen(
    state: ExchangeState = ExchangeState(),
    intent: ExchangeIntent = ExchangeIntent.Empty,
    navigator: Navigator = Navigator.Empty
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background.primary)
            .navigationBarsPadding()
    ) {
        val (
            toolbar: ConstrainedLayoutReference,
            txtMyBalances: ConstrainedLayoutReference,
            listBalances: ConstrainedLayoutReference,
            txtCurrencyExchange: ConstrainedLayoutReference,
            exchangeCurrencySell: ConstrainedLayoutReference,
            exchangeCurrencyReceive: ConstrainedLayoutReference,
            currencyDivider: ConstrainedLayoutReference,
            btnSubmit: ConstrainedLayoutReference,
        ) = createRefs()

        val space8 = AppTheme.dimensions.space_8
        val space16 = AppTheme.dimensions.space_16
        val space24 = AppTheme.dimensions.space_24
        val space32 = AppTheme.dimensions.space_32
        val space56 = AppTheme.dimensions.space_56

        val startBorder = createGuidelineFromStart(AppTheme.dimensions.space_16)
        val endBorder = createGuidelineFromEnd(AppTheme.dimensions.space_16)

        Toolbar(
            modifier = Modifier.constrainAs(toolbar) {
                top.linkTo(parent.top)
            },
            title = stringResource(R.string.exchange_toolbar_title)
        )

        Text(
            modifier = Modifier.constrainAs(txtMyBalances) {
                width = Dimension.fillToConstraints
                height =  Dimension.wrapContent
                top.linkTo(toolbar.bottom, space16)
                start.linkTo(startBorder)
                end.linkTo(endBorder)
            },
            text = stringResource(R.string.exchange_my_balances).uppercase(),
            style = AppTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = AppTheme.colors.content.secondary,
            textAlign = TextAlign.Start
        )

        Balances(
            modifier = Modifier.constrainAs(listBalances) {
                width = Dimension.matchParent
                height = Dimension.wrapContent
                top.linkTo(txtMyBalances.bottom, space16)
            },
            balances = state.balances
        )

        Text(
            modifier = Modifier.constrainAs(txtCurrencyExchange) {
                width = Dimension.fillToConstraints
                height =  Dimension.wrapContent
                top.linkTo(listBalances.bottom, space32)
                start.linkTo(startBorder)
                end.linkTo(endBorder)
            },
            text = stringResource(R.string.exchange_currency_exchange).uppercase(),
            style = AppTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = AppTheme.colors.content.secondary,
            textAlign = TextAlign.Start
        )

        ExchangeCurrency(
            modifier = Modifier.constrainAs(exchangeCurrencySell) {
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
                top.linkTo(txtCurrencyExchange.bottom, space8)
                start.linkTo(startBorder)
                end.linkTo(endBorder)
            },
            icon = painterResource(AppTheme.icons.arrowUp),
            iconTint = AppTheme.colors.core.negative,
            title = stringResource(R.string.exchange_sell),
            amount = state.amountSell,
            amountColor = AppTheme.colors.content.primary,
            rates = state.exchangeRate.rates,
            selected = state.selectedCurrencySell,
            onChangeSelected = intent::onChangeCurrencySell,
            onChangeAmount = intent::onChangeAmountSell
        )

        HorizontalDivider(
            modifier = Modifier.constrainAs(currencyDivider) {
                width = Dimension.fillToConstraints
                top.linkTo(exchangeCurrencySell.bottom)
                start.linkTo(startBorder, space56)
                end.linkTo(endBorder)
            },
            thickness = AppTheme.dimensions.size_2,
            color = AppTheme.colors.border.primary
        )

        ExchangeCurrency(
            modifier = Modifier.constrainAs(exchangeCurrencyReceive) {
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
                top.linkTo(currencyDivider.bottom)
                start.linkTo(startBorder)
                end.linkTo(endBorder)
            },
            icon = painterResource(AppTheme.icons.arrowDown),
            iconTint = AppTheme.colors.core.positive,
            title = stringResource(R.string.exchange_receive),
            amount = if (state.isProfitableExchange) {
                stringResource(R.string.exchange_positive_amount, state.amountReceive)
            } else {
                state.amountReceive
            },
            amountColor = if (state.isProfitableExchange) {
                AppTheme.colors.core.positive
            } else {
                AppTheme.colors.content.primary
            },
            rates = state.exchangeRate.rates,
            selected = state.selectedCurrencyReceive,
            isEnabledInput = false,
            onChangeSelected = intent::onChangeCurrencyReceive,
            onChangeAmount = {}
        )

        ExchangerButton(
            modifier = Modifier
                .constrainAs(btnSubmit) {
                    width = Dimension.fillToConstraints
                    bottom.linkTo(parent.bottom, space24)
                    centerHorizontallyTo(parent, space32)
                },
            title = stringResource(R.string.exchange_submit),
            onClick = intent::submit
        )
    }
}