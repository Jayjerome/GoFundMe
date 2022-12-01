package com.gads.crowdfunding.dashboard

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.PermissionChecker
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.gads.crowdfunding.R
import com.gads.crowdfunding.databinding.FragmentNewProjectBinding

class NewProjectFragment : Fragment(R.layout.fragment_new_project){
    private lateinit var binding: FragmentNewProjectBinding
    private val IMAGE_PICK_CODE = 1000
    private val PERMISSION_CODE = 1001

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNewProjectBinding.bind(view)


        //Set a listener to open the gallery
        binding.addImage.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(checkSelfPermission(view.context,"Manifest.permission.READ_EXTERNAL_STORAGE") == PermissionChecker.PERMISSION_DENIED){
                    //permission Denied
                    val permission = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    //show pop up to request runtime permission
                    requestPermissions(permission, PERMISSION_CODE)
                }else{
                    //Permission already granted
                    pickImageFromGallery()
                }
            }else{
                //System OS is < MarshMellow
                pickImageFromGallery()
            }
        }

        //set a listener to open the gallery
        binding.gallery.setOnClickListener {
            val intent = Intent("android.media.action.IMAGE_CAPTURE")
            startActivity(intent)
        }
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)

    }

    //Handling Permission result
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            PERMISSION_CODE ->  {
                if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //Permission from pop up granted
                    pickImageFromGallery()
                }else{
                    //Permission from pop up declined
                    Toast.makeText(context,"Permission declined", Toast.LENGTH_LONG).show()
                }

            }
        }
    }

    //Handle image pick result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            binding.gallery.setImageURI(data?.data)
            binding.txtprojectImage.isVisible = false
            binding.addImage.isVisible = false
        }
    }
}