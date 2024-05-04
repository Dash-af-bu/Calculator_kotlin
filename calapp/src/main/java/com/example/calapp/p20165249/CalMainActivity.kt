package com.example.calapp.p20165249

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.calapp.databinding.ActivityCalMainBinding
import com.example.calapp.p20165249.BasicActivity
import com.example.calapp.p20165249.EnginActivity
import com.example.calapp.p20165249.NotationActivity
import com.example.calapp.p20165249.databinding.ActivityCalMainBinding


class CalMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewBinding을 사용하여 레이아웃을 로드합니다.
        val binding = ActivityCalMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ActivityResultLauncher를 초기화합니다.
        val reqLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){

        }
        // "oper1" 버튼에 대한 클릭 리스너를 설정합니다
        binding.oper1.setOnClickListener{
            // BasicActivity로 이동하는 Intent를 생성합니다.
            val intent = Intent(this, BasicActivity::class.java)
            // 생성한 Intent를 사용하여 ActivityResultLauncher를 실행합니다.
            reqLauncher.launch(intent)
        }
        binding.oper2.setOnClickListener{
            // EnginActivity로 이동하는 Intent를 생성합니다.
            val intent = Intent(this, EnginActivity::class.java)
            // 생성한 Intent를 사용하여 ActivityResultLauncher를 실행합니다.
            reqLauncher.launch(intent)
        }
        binding.oper3.setOnClickListener{
            // NotationActivity로 이동하는 Intent를 생성합니다.
            val intent = Intent(this, NotationActivity::class.java)
            // 생성한 Intent를 사용하여 ActivityResultLauncher를 실행합니다.
            reqLauncher.launch(intent)
        }

    }
}