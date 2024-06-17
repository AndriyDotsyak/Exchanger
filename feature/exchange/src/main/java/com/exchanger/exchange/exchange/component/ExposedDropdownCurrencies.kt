package com.exchanger.exchange.exchange.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import com.exchanger.model.balance.Balance
import com.exchanger.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownCurrencies(
    modifier: Modifier = Modifier,
    balances: List<Balance>,
    selected: Balance,
    onChangeSelected: (item: Balance) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = isExpanded,
        onExpandedChange = { value ->
            isExpanded = value
        },
    ) {
        Row(
            modifier = Modifier.menuAnchor(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.width(AppTheme.dimensions.size_44),
                text = selected.name,
                style = AppTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = AppTheme.colors.content.primary,
                maxLines = 1,
            )

            Icon(
                modifier = Modifier.rotate(
                    if (isExpanded) 180f else 0f
                ),
                imageVector = Icons.Filled.ArrowDropDown,
                tint = AppTheme.colors.content.primary,
                contentDescription = null
            )
        }

        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            for (item in balances) {
                DropdownMenuItem(
                    modifier = Modifier,
                    text = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = item.name,
                            style = AppTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 1
                        )
                    },
                    onClick = {
                        onChangeSelected(item)
                        isExpanded = false
                    }
                )
            }
        }
    }
}