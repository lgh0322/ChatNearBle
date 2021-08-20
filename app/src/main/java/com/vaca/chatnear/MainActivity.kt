package com.vaca.chatnear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vaca.chatnear.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)







        val buttonAdapter = RecordButtonAdapter(requireContext())
        val lm = object : LinearLayoutManager(requireContext(), HORIZONTAL, false) {
            override fun canScrollHorizontally(): Boolean {
                return false
            }
        }
        binding.topButton.layoutManager = lm
        buttonAdapter.addAll(arrayOf("心电记录", "血压、血氧记录", "体温记录"))
        buttonAdapter.myGo = object : RecordButtonAdapter.WantInfo {
            override fun go(u: Int) {
                if (currentIndex == u) {
                    return
                }
                currentIndex = u
                if (navController.popBackStack(topId[u], false)) {

                } else {
                    navController.navigate(topId[u])
                }

            }

        }
        binding.topButton.adapter = buttonAdapter
    }
}