package com.example.jetpackcompose.ui.composeElements

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur

@Composable
fun BlurEffect(){
    var checked by remember { mutableStateOf(false) }
    val animatedBlur by animateDpAsState(targetValue = if(checked) 10.dp else 0.dp )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.blur(radius = animatedBlur, edgeTreatment = BlurredEdgeTreatment.Unbounded),
            text = "Hello"
        )

        Spacer(modifier = Modifier.height(16.dp))
        Switch(checked = checked, onCheckedChange = {checked =!checked})
    }

}