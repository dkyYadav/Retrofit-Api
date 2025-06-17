package com.example.retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.retrofit.model.postResposeItem
import com.example.retrofit.ui.theme.RetrofitTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitTheme()

        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun RetrofitTheme() {

     val apiInterface: APIInterface by lazy { RetrofitInstance.getapiservice() }

    var post by remember { mutableStateOf<List<postResposeItem>>(emptyList()) }

    LaunchedEffect(Unit) {
        post = apiInterface.getPost()
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        LazyColumn (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ){

            items (post){

                Card(modifier = Modifier.fillMaxSize()
                    .padding(horizontal = 12.dp, vertical = 12.dp)


                ) {

                    Text(it.id.toString())
                    Text(it.userId.toString())
                    Text(it.title.toString())
                    Text(it.body.toString())

                }




            }
        }




    }
}
