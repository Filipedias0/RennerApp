package com.example.rennerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val data = intent.extras
        val detailsImageNumberM = data?.getInt("imageNumberM")
        val detailsImageNumberW = data?.getInt("imageNumberW")
        val detailsText = data?.getString("detailsText")
        val boolW = data?.getBoolean("boolW")

        val imageListDetails = ArrayList<SlideModel>()


        if(boolW == false){
            when (detailsImageNumberM) {
                0 -> {
                    imageListDetails.add(SlideModel(R.drawable.m_clothes_1_1, ScaleTypes.FIT))
                    imageListDetails.add(SlideModel(R.drawable.m_clothes_1_2, ScaleTypes.FIT))
                    val textViewDetails = findViewById<TextView>(R.id.textViewDetailsTitle)
                    textViewDetails.text = detailsText

                    //imageListMDetails.add(SlideModel(R.drawable.m_clothes_alt_1_1, ScaleTypes.FIT))
                    //imageListMDetails.add(SlideModel(R.drawable.m_clothes_alt_1_2, ScaleTypes.FIT))
                }

                1 -> {
                    imageListDetails.add(SlideModel(R.drawable.m_clothes_2_1, ScaleTypes.FIT))
                    imageListDetails.add(SlideModel(R.drawable.m_clothes_2_2, ScaleTypes.FIT))
                }

                2 -> {
                    imageListDetails.add(SlideModel(R.drawable.m_clothes_3_1, ScaleTypes.FIT))
                    imageListDetails.add(SlideModel(R.drawable.m_clothes_3_2, ScaleTypes.FIT))
                }
            }
        }

        if(boolW == true){
            when (detailsImageNumberW) {
                0 -> {
                    imageListDetails.add(SlideModel(R.drawable.w_clothes_1_1, ScaleTypes.FIT))
                    imageListDetails.add(SlideModel(R.drawable.w_clothes_1_2, ScaleTypes.FIT))
                    //imageListMDetails.add(SlideModel(R.drawable.m_clothes_alt_1_1, ScaleTypes.FIT))
                    //imageListMDetails.add(SlideModel(R.drawable.m_clothes_alt_1_2, ScaleTypes.FIT))
                }

                1 -> {
                    imageListDetails.add(SlideModel(R.drawable.w_clothes_2_1, ScaleTypes.FIT))
                    imageListDetails.add(SlideModel(R.drawable.w_clothes_2_2, ScaleTypes.FIT))
                }

                2 -> {
                    imageListDetails.add(SlideModel(R.drawable.w_clothes_3_1, ScaleTypes.FIT))
                    imageListDetails.add(SlideModel(R.drawable.w_clothes_3_2, ScaleTypes.FIT))
                }
            }
        }


        val detailsImageSlider = findViewById<ImageSlider>(R.id.details_image_slider)

        detailsImageSlider.setImageList(imageListDetails)

    }
}