package com.example.rennerapp

import android.content.res.ColorStateList
import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.ViewCompat
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemChangeListener
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
        val price = data?.getString("price")
        val oldPrice = data?.getString("oldPrice")
        val discount = data?.getString("discount")
        var imageListDetails = ArrayList<SlideModel>()
        val detailsImageSlider = findViewById<ImageSlider>(R.id.details_image_slider)

        val textViewDetails = findViewById<TextView>(R.id.textViewDetailsTitle)
        val textViewDiscount = findViewById<TextView>(R.id.textViewDiscount)
        val textViewPrice = findViewById<TextView>(R.id.textViewOldPrice)
        val textViewNewPrice = findViewById<TextView>(R.id.textViewNewPrice)
        val colorBox = findViewById<LinearLayout>(R.id.colorBox)
        val colorBoxView = findViewById<LinearLayout>(R.id.colorBoxStroke)
        val colorBoxViewAlt = findViewById<LinearLayout>(R.id.colorBoxStrokeAlt)
        val backButton = findViewById<ImageView>(R.id.goBack)

        textViewPrice.text = oldPrice
        textViewNewPrice.text = price
        textViewDetails.text = detailsText
        textViewDiscount.text = discount

        backButton.setOnClickListener {
            finish()
        }

        if(detailsText != "Blusão Em Moletom com Capuz e Bolso Canguru" || boolW == true) {
            colorBoxViewAlt.visibility = View.GONE
        }

        if(boolW == false && detailsText == "Blusão Em Moletom com Capuz e Bolso Canguru"){
            colorBoxViewAlt.setOnClickListener {
                val newImageList = ArrayList<SlideModel>()

                newImageList.add(SlideModel(R.drawable.m_clothes_alt_1_1, ScaleTypes.FIT))
                newImageList.add(SlideModel(R.drawable.m_clothes_alt_1_2, ScaleTypes.FIT))
                detailsImageSlider.setImageList(newImageList, ScaleTypes.FIT)
            }

            colorBoxView.setOnClickListener {
                val newImageList = ArrayList<SlideModel>()
                newImageList.add(SlideModel(R.drawable.m_clothes_1_1, ScaleTypes.FIT))
                newImageList.add(SlideModel(R.drawable.m_clothes_1_2, ScaleTypes.FIT))

                detailsImageSlider.setImageList(newImageList, ScaleTypes.FIT)
            }
        }

        if(boolW == false){
            when (detailsImageNumberM) {
                0 -> {
                    imageListDetails.add(SlideModel(R.drawable.m_clothes_1_1, ScaleTypes.FIT))
                    imageListDetails.add(SlideModel(R.drawable.m_clothes_1_2, ScaleTypes.FIT))
                    ViewCompat.setBackgroundTintList(
                        colorBox,
                        ColorStateList.valueOf(Color.parseColor("#4495d4"))
                    )


                }

                1 -> {
                    imageListDetails.add(SlideModel(R.drawable.m_clothes_2_1, ScaleTypes.FIT))
                    imageListDetails.add(SlideModel(R.drawable.m_clothes_2_2, ScaleTypes.FIT))
                    ViewCompat.setBackgroundTintList(
                        colorBox,
                        ColorStateList.valueOf(Color.parseColor("#eedad3"))
                    )
                }

                2 -> {
                    imageListDetails.add(SlideModel(R.drawable.m_clothes_3_1, ScaleTypes.FIT))
                    imageListDetails.add(SlideModel(R.drawable.m_clothes_3_2, ScaleTypes.FIT))
                    ViewCompat.setBackgroundTintList(
                        colorBox,
                        ColorStateList.valueOf(Color.parseColor("#e5e2da"))
                    )
                }
            }
        }

        if(boolW == true){
            when (detailsImageNumberW) {
                0 -> {
                    imageListDetails.add(SlideModel(R.drawable.w_clothes_1_1, ScaleTypes.FIT))
                    imageListDetails.add(SlideModel(R.drawable.w_clothes_1_2, ScaleTypes.FIT))
                    colorBox.setBackgroundColor(Color.parseColor("#181312"))

                    //imageListMDetails.add(SlideModel(R.drawable.m_clothes_alt_1_1, ScaleTypes.FIT))
                    //imageListMDetails.add(SlideModel(R.drawable.m_clothes_alt_1_2, ScaleTypes.FIT))
                }

                1 -> {
                    imageListDetails.add(SlideModel(R.drawable.w_clothes_2_1, ScaleTypes.FIT))
                    imageListDetails.add(SlideModel(R.drawable.w_clothes_2_2, ScaleTypes.FIT))
                    colorBox.setBackgroundColor(Color.parseColor("#d0dedc"))

                }

                2 -> {
                    imageListDetails.add(SlideModel(R.drawable.w_clothes_3_1, ScaleTypes.FIT))
                    imageListDetails.add(SlideModel(R.drawable.w_clothes_3_2, ScaleTypes.FIT))
                    colorBox.setBackgroundColor(Color.parseColor("#e9e2d9"))

                }
            }
        }


        detailsImageSlider.setItemChangeListener(object : ItemChangeListener {
            override fun onItemChanged(position: Int) {
                val textViewCarouselIndex = findViewById<TextView>(R.id.textViewCarouselIndex)
                textViewCarouselIndex.text = "${ position + 1 }/${ imageListDetails.size }"
            }
        })

        detailsImageSlider.setImageList(imageListDetails)

    }
}