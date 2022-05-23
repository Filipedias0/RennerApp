package com.example.rennerapp

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.ViewCompat
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemChangeListener
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
        val imageListM = ArrayList<SlideModel>()

        imageListM.add(SlideModel(R.drawable.m_clothes_1_1, ScaleTypes.FIT))
        imageListM.add(SlideModel(R.drawable.m_clothes_2_1, ScaleTypes.FIT))
        imageListM.add(SlideModel(R.drawable.m_clothes_3_1, ScaleTypes.FIT))

        val imageSliderM = findViewById<ImageSlider>(R.id.image_slider_m)
        val textViewClothesM = findViewById<TextView>(R.id.textViewClothesM)
        val textViewClothesMDesc = findViewById<TextView>(R.id.textViewClothesMDesc)
        val textViewClothesMPrice = findViewById<TextView>(R.id.textViewClothesMPrice)
        val textViewClothesMOldPrice = findViewById<TextView>(R.id.textViewOldPriceM)
        val textViewDiscountM = findViewById<TextView>(R.id.textViewDiscountM)
        val textViewDiscountW = findViewById<TextView>(R.id.textViewDiscountW)
        val colorBoxM = findViewById<LinearLayout>(R.id.colorBoxSuggestedM)
        val colorBoxW = findViewById<LinearLayout>(R.id.colorBoxSuggestedW)

        imageSliderM.setImageList(imageListM)

        imageSliderM.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                val productDetails = Intent( context , DetailsActivity::class.java)
                productDetails.putExtra("imageNumberM", position)
                    productDetails.putExtra(
                        "detailsText",
                        "${textViewClothesM.text} ${textViewClothesMDesc.text}"
                    )
                productDetails.putExtra("oldPrice", textViewClothesMOldPrice.text)
                productDetails.putExtra("price", textViewClothesMPrice.text)
                productDetails.putExtra("discount", textViewDiscountM.text)
                startActivity(productDetails)
            }
        })

        imageSliderM.setItemChangeListener(object : ItemChangeListener {
                override fun onItemChanged(position: Int) {

                    when (position) {
                        0 -> {
                            textViewClothesM.text = "Blusão"
                            textViewClothesMDesc.text = "Em Moletom com Capuz e Bolso Canguru"
                            textViewClothesMPrice.text = "R$ 133,63"
                            textViewClothesMOldPrice.text = "R$190,90"
                            textViewDiscountM.text = "30%"

                            ViewCompat.setBackgroundTintList(
                                colorBoxM,
                                ColorStateList.valueOf(Color.parseColor("#e9edeb"))
                            )
                        }

                        1 -> {
                            textViewClothesM.text = "Moletom"
                            textViewClothesMDesc.text =
                                "Com capuz ajustável e estampa lettering Califórnia rosa"
                            textViewClothesMPrice.text = "R$ 135,98"
                            textViewClothesMOldPrice.text = "R$190,90"
                            textViewDiscountM.text = "20%"
                            ViewCompat.setBackgroundTintList(
                                colorBoxM,
                                ColorStateList.valueOf(Color.parseColor("#99948e"))
                            )
                        }

                        2 -> {
                            textViewClothesM.text = "Blusão"
                            textViewClothesMDesc.text =
                                "Com gola com capuz e manga longa com ribana"
                            textViewClothesMPrice.text = "R$ 120,90"
                            textViewClothesMOldPrice.text = "R$200,90"
                            textViewDiscountM.text = "40%"
                            ViewCompat.setBackgroundTintList(
                                colorBoxM,
                                ColorStateList.valueOf(Color.parseColor("#9c6f51"))
                            )
                        }
                    }
                }
        })

        val imageListW = ArrayList<SlideModel>()

        imageListW.add(SlideModel(R.drawable.w_clothes_1_1, ScaleTypes.FIT))
        imageListW.add(SlideModel(R.drawable.w_clothes_2_1, ScaleTypes.FIT))
        imageListW.add(SlideModel(R.drawable.w_clothes_3_1, ScaleTypes.FIT))

        val textViewClothesW = findViewById<TextView>(R.id.textViewClothesW)
        val textViewClothesWDesc = findViewById<TextView>(R.id.textViewClothesWDesc)
        val textViewClothesWOldPrice = findViewById<TextView>(R.id.textViewClothesWOldPrice)
        val textViewClothesWPrice = findViewById<TextView>(R.id.textViewClothesWPrice)

        val imageSliderW = findViewById<ImageSlider>(R.id.image_slider_w)
        imageSliderW.setImageList(imageListW)

        imageSliderW.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                val productDetails = Intent( context , DetailsActivity::class.java)
                productDetails.putExtra("imageNumberW", position)
                productDetails.putExtra("boolW", true)
                productDetails.putExtra("price", textViewClothesWPrice.text)
                productDetails.putExtra(
                    "detailsText",
                    "${textViewClothesM.text} ${textViewClothesMDesc.text}"
                )
                productDetails.putExtra("oldPrice", textViewClothesWOldPrice.text)
                productDetails.putExtra("price", textViewClothesWPrice.text)
                productDetails.putExtra("discount", textViewDiscountW.text)
                startActivity(productDetails)
            }
        })

        imageSliderW.setItemChangeListener(object: ItemChangeListener {

            override fun onItemChanged(position: Int) {
                when (position){
                    0 -> {
                        textViewClothesW.text = "Blusa em Viscose"
                        textViewClothesWDesc.text = "Com manga longa comfy preto"

                        textViewClothesWPrice.text = "R$ 84,63"
                        textViewClothesWOldPrice.text = "R$120,90"
                        textViewDiscountW.text = "30%"
                        ViewCompat.setBackgroundTintList(
                            colorBoxW,
                            ColorStateList.valueOf(Color.parseColor("#a79691"))
                        )
                    }

                    1 -> {
                        textViewClothesW.text = "Blusa manga longa"
                        textViewClothesWDesc.text = "Em Tricô com pontos diferenciados verde"
                        textViewClothesWPrice.text = "R$ 132,54"
                        textViewClothesWOldPrice.text = "R$220,90"
                        textViewDiscountW.text = "40%"
                        ViewCompat.setBackgroundTintList(
                            colorBoxW,
                            ColorStateList.valueOf(Color.parseColor("#d0b298"))
                        )

                    }

                    2 -> {
                        textViewClothesW.text = "Blusa alongada em tricô"
                        textViewClothesWDesc.text = "Com golinha alta e fenda bege"
                        textViewClothesWPrice.text = "R$ 60,45"
                        textViewClothesWOldPrice.text = "R$120,90"
                        textViewDiscountW.text = "50%"
                        ViewCompat.setBackgroundTintList(
                            colorBoxW,
                            ColorStateList.valueOf(Color.parseColor("#ada897"))
                        )
                    }
                }
            }
        })
    }
}