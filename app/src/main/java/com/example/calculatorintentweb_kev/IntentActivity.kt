package com.example.calculatorintentweb_kev

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class IntentActivity : AppCompatActivity() {
    lateinit var ButtonCamera: Button
    lateinit var ButtonStk: Button
    lateinit var ButtonEmail: Button
    lateinit var ButtonSms: Button
    lateinit var ButtonCall: Button
    lateinit var ButtonDial: Button
    lateinit var ButtonShare: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        ButtonCamera=findViewById(R.id.Btn_camera)
        ButtonStk=findViewById(R.id.Btn_STK)
        ButtonEmail=findViewById(R.id.Btn_email)
        ButtonSms=findViewById(R.id.Btn_sms)
        ButtonCall=findViewById(R.id.Btn_call)
        ButtonDial=findViewById(R.id.Btn_dial)
        ButtonShare=findViewById(R.id.Btn_share)

        ButtonSms!!.setOnClickListener {
            val uri = Uri.parse("smsto:0741629895")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("sms_body", "The SMS text")

            startActivity(intent)
        }
        ButtonCamera!!.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(takePictureIntent,1)

        }
        ButtonEmail!!.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }
        ButtonShare!!.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT,"Hey,download this app!")
            startActivity(shareIntent)
        }
        ButtonStk!!.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { startActivity(it) }

        }
            ButtonDial!!.setOnClickListener {
                val phone = "+34666777888"

                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

                startActivity(intent)


            }
            ButtonCall!!.setOnClickListener {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))

                if (ContextCompat.checkSelfPermission(
                        this@IntentActivity,
                        android.Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this@IntentActivity,
                        arrayOf(android.Manifest.permission.CALL_PHONE),
                        1
                    )
                } else {
                    startActivity(intent)
                }


            }

    }
}