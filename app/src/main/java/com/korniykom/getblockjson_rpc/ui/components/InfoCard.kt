package com.korniykom.getblockjson_rpc.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.korniykom.getblockjson_rpc.ui.theme.LightGrey
import com.korniykom.getblockjson_rpc.ui.theme.ELEVATION_SMALL
import com.korniykom.getblockjson_rpc.ui.theme.Grey
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_EXTRASMALL
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_MEDIUM

@Composable
fun InfoCard(
    modifier: Modifier = Modifier,
    title: String = "Empty",
    subTitle: String = "Empty",
    firstSectionTitle: String = "Empty",
    firstSectionSubtitle: String = "Empty",
    secondSectionTitle: String = "Empty",
    secondSectionSubtitle: String = "Empty",
    onClick: () -> Unit = {}
) {
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = LightGrey
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(PADDING_MEDIUM),
        elevation = CardDefaults.cardElevation(ELEVATION_SMALL)
    ) {
        Column(modifier = modifier.padding(PADDING_MEDIUM)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                modifier = modifier.padding(bottom = PADDING_EXTRASMALL)
            )
            Text(
                text = subTitle,
                style = MaterialTheme.typography.headlineSmall,
                modifier = modifier.padding(bottom = PADDING_MEDIUM)
            )
            InnerCard(
                firstSectionTitle = firstSectionTitle,
                firstSectionSubtitle = firstSectionSubtitle,
                secondSectionTitle = secondSectionTitle,
                secondSectionSubtitle = secondSectionSubtitle
            )
        }
    }
}

@Composable
fun InnerCard(
    modifier: Modifier = Modifier,
    firstSectionTitle: String = "Empty",
    firstSectionSubtitle: String = "Empty",
    secondSectionTitle: String = "Empty",
    secondSectionSubtitle: String = "Empty"
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Grey
        )
    ) {
        Column(modifier = modifier.padding(PADDING_MEDIUM)) {
            Text(
                text = firstSectionTitle,
                style = MaterialTheme.typography.labelSmall,
                modifier = modifier.padding(bottom = PADDING_EXTRASMALL)
            )
            Text(firstSectionSubtitle)

            HorizontalDivider(
                modifier = modifier
                    .padding(vertical = PADDING_MEDIUM)
                    .fillMaxWidth()
            )

            Text(
                text = secondSectionTitle,
                style = MaterialTheme.typography.labelSmall,
                modifier = modifier.padding(bottom = PADDING_EXTRASMALL)
            )
            Text(secondSectionSubtitle)
        }
    }
}