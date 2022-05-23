package com.example.rennerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
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

        imageSliderM.setImageList(imageListM)


        imageSliderM.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                val productDetails = Intent( context , DetailsActivity::class.java)
                productDetails.putExtra("imageNumberM", position)
                    productDetails.putExtra(
                        "detailsText",
                        "${textViewClothesM.text} ${textViewClothesMDesc.text}"
                    )
                productDetails.putExtra("price", textViewClothesMPrice.text)
                startActivity(productDetails)
            }
        })

        imageSliderM.setItemChangeListener(object : ItemChangeListener {
                override fun onItemChanged(position: Int) {

                    when (position) {
                        0 -> {
                            textViewClothesM.text = "Blusão"
                            textViewClothesMDesc.text = "Em Moletom com Capuz e Bolso Canguru"
                            textViewClothesMPrice.text = "R$ 159,90"
                        }

                        1 -> {
                            textViewClothesM.text = "Moletom"
                            textViewClothesMDesc.text =
                                "Com capuz ajustável e estampa lettering Califórnia rosa"
                            textViewClothesMPrice.text = "R$ 169,90"
                        }

                        2 -> {
                            textViewClothesM.text = "Blusão"
                            textViewClothesMDesc.text =
                                "Com gola com capuz e manga longa com ribana"
                            textViewClothesMPrice.text = "R$ 149,90"
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
                productDetails.putExtra("price", textViewClothesWPrice.text)
                startActivity(productDetails)
            }
        })

        imageSliderW.setItemChangeListener(object: ItemChangeListener {

            override fun onItemChanged(position: Int) {
                when (position){
                    0 -> {
                        textViewClothesW.text = "Blusa em Viscose"
                        textViewClothesWDesc.text = "Com manga longa comfy preto"
                        textViewClothesWPrice.text = "R$ 99,90"
                    }

                    1 -> {
                        textViewClothesW.text = "Blusa manga longa"
                        textViewClothesWDesc.text = "Em Tricô com pontos diferenciados verde"
                        textViewClothesWPrice.text = "R$ 199,90"
                    }

                    2 -> {
                        textViewClothesW.text = "Blusa alongada em tricô"
                        textViewClothesWDesc.text = "Com golinha alta e fenda bege"
                        textViewClothesWPrice.text = "R$ 99,90"
                    }
                }
            }
        })
    }
}