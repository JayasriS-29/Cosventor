package com.jayasri.studentdisplay.ui.theme

import android.R
import com.jayasri.studentdisplay.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StudentView(data: StudentData, modifier: Modifier = Modifier) {
    val clrScheme = if (data.gender == Gender.FEMALE) GirlColorScheme else BoyColorScheme
    val cornerRadius = 12.dp
    val cgpaPanelWidth = 90.dp

    val idTextStyle = TextStyle(
        color = clrScheme.idTextColor,
        fontSize = 10.sp
    )
    val nameTextStyle = TextStyle(
        color = clrScheme.nameTextColor,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
    val departTextStyle = TextStyle(
        color = clrScheme.departTextColor,
        fontSize = 12.sp
    )
    val livingTypeTextStyle = TextStyle(
        color = clrScheme.livingTextColor,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold
    )
    val cgpaTextStyle = TextStyle(
        color = clrScheme.cgpaTextColor,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold
    )
    val cgpaLabelTextStyle = TextStyle(
        color = clrScheme.cgpaTextColor,
        fontSize = 10.sp
    )

    Box(
        modifier = modifier

    ) {
       //main info
        Row(
            modifier = Modifier
                .padding(top=10.dp)
        ) {
            //photo & info
           Surface(color=clrScheme.infoBgColor,shape= RoundedCornerShape
               (topStart = cornerRadius, topEnd = cornerRadius),
               modifier=Modifier.fillMaxHeight()){
              Row(
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.spacedBy(10.dp),
                  modifier=Modifier.padding(8.dp)
              ){
                  //photoholder
                  Surface(color=Color.LightGray,
                      shape=CircleShape,
                      modifier=Modifier.size(80.dp),)
                  {

                  }
                  //info
                  Column(modifier=Modifier){
                      Text(text=data.id, style=idTextStyle)
                      Text(text="${data.fname} ${data.lname}",style=nameTextStyle)
                      Text(text=data.department,style=departTextStyle)

                  }
           }

            Surface(
                   color = clrScheme.cgbaBgColor,
            shape = RoundedCornerShape(
                topEnd = cornerRadius,
                bottomEnd = cornerRadius) ,
                modifier = Modifier
                        .fillMaxSize()



            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 8.dp)
            ) {
                Text(text = "${data.cgpa}", style = cgpaTextStyle)
                Text(text = "out of 10", style = cgpaLabelTextStyle)
            }
        }




            }
        }


        // ---- Living Type badge (top, floating over the card) ----
        Surface(color=clrScheme.livingTypeBgColor,
            shape = RoundedCornerShape(size = 16.dp),
            modifier=Modifier.align(Alignment.TopEnd).offset(x=(-80.dp))
        ) {
            Text(
                text = if (data.livingType == LivingType.HOSTELLER) "Hosteller" else "Dayscholar",
                style = livingTypeTextStyle,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )
        }
    }
}

// ---------- List wrapper ----------

@Composable
fun StudentListPreview(students: List<StudentData>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        students.forEach { student ->
            StudentView(
                data = student,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 6.dp)
            )
        }
    }
}


@Preview(showBackground = false,heightDp=120)
@Composable
fun StudentViewPreview() {
        val s1= StudentData(
            fname = "Jaya Sri",
            lname = "S",
            department = "Computer Science & Engineering",
            cgpa = 8.6f,
            livingType = LivingType.HOSTELLER,
            photo="p1",
            gender = Gender.FEMALE
        )
    StudentDisplayTheme(){
        StudentView(data=s1)
    }

}



