package com.example.intents_ezra

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnsms:Button
    lateinit var btnemail:Button
    lateinit var btncam:Button
    lateinit var btnshare:Button
    lateinit var btnmpesa:Button
    lateinit var btncall:Button
    lateinit var btnweb:Button
    lateinit var btnmap:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnsms = findViewById(R.id.btn_sms)
        btnemail = findViewById(R.id.btn_email)
        btncam = findViewById(R.id.btn_cam)
        btnshare = findViewById(R.id.btn_share)
        btnmpesa = findViewById(R.id.btn_mpesa)
        btncall = findViewById(R.id.btn_call)
        btnweb = findViewById(R.id.btn_web)
        btnmap = findViewById(R.id.btn_map)

        btnsms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0743322307")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body","Hello")
            startActivity(intent)
        }
        btnemail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","mogambiezra@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT,"JOB APPLICATION")
            emailIntent.putExtra(Intent.EXTRA_TEXT,"Dear Sir, I'm applying for ")
            startActivity(Intent.createChooser(emailIntent, "Send email"))
        }
        btncam.setOnClickListener {
            val takePictureintent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureintent,1)
        }
        btnmpesa.setOnClickListener {
            val simToolKITIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKITIntent?.let { startActivity(it) }
        }

    }
}