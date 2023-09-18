package com.programtest.tryj.presentation.chart

import android.content.Context
import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.programtest.tryj.domain.model.chart.ChartResponseItem
import com.programtest.tryj.presentation.chart.components.DonutChartData
import com.programtest.tryj.presentation.chart.components.DonutChartDataCollection
import com.programtest.tryj.ui.theme.MetallicYellow
import com.programtest.tryj.ui.theme.OxfordBlue
import com.programtest.tryj.ui.theme.RobingEggBlue
import com.programtest.tryj.ui.theme.Sapphire
import com.programtest.tryj.ui.theme.VividOrange
import java.io.IOException

val viewData = DonutChartDataCollection(
    listOf(
        DonutChartData(1200.0f, Sapphire, title = "Food & Groceries"),
        DonutChartData(1500.0f, RobingEggBlue, title = "Rent"),
        DonutChartData(300.0f, MetallicYellow, title = "Gas"),
        DonutChartData(700.0f, OxfordBlue, title = "Online Purchases"),
        DonutChartData(300.0f, VividOrange, title = "Clothing")
    )
)

fun getChartJson(context: Context):List<ChartResponseItem>{
    lateinit var jsonString: String
    try {
        jsonString = context.assets.open("jsonchart.json")
            .bufferedReader()
            .use { it.readText()
            }
        Log.d("jsonbaca",jsonString)

    } catch (ioException: IOException) {
        Log.d("error",ioException.toString())
    }

    val listChartType = object : TypeToken<List<ChartResponseItem>>() {}.type
    return Gson().fromJson(jsonString,listChartType)
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun ChartScreen(){

 Log.d("tesss", getChartJson(LocalContext.current).toString())


//    Scaffold(
//        topBar = {
//            Text("Fancy Donut Chart",
//                style = Typography.displaySmall,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(20.dp))
//        }
//    ) { paddingValues ->
//        DonutChart(Modifier.padding(paddingValues), data = viewData) { selected ->
//            AnimatedContent(targetState = selected) {
//                val amount = it?.amount ?: viewData.totalAmount
//                val text = it?.title ?: "Total"
//
//                Column(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text("$${amount.toMoneyFormat(true)}",
//                        style = moneyAmountStyle, color = PetroleumGray)
//                    Text(text, style = itemTextStyle, color = PetroleumLightGray)
//                }
//            }
//        }
//    }
}
















