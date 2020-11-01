package com.example.roomdatabaseexample.main

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabaseexample.R
import com.example.roomdatabaseexample.repository.database.entities.Fakultaet
import com.google.android.material.textfield.TextInputLayout

class DialogInput(var fakultaet: Fakultaet? = null):DialogFragment()
{

    private lateinit var rootView:View

    // Buttons:
    private lateinit var btnSave:Button
    private lateinit var btnAbort:Button

    // TextInputLayout
    private lateinit var etNative:TextInputLayout
    private lateinit var etForeign:TextInputLayout

    // ViewModel:
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(
            STYLE_NO_FRAME,
            R.style.FullScreenDialog)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.dialog_input,container,false)
        //dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        return rootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity(),MainViewModelFactory(requireActivity().application)).get(MainViewModel::class.java)
        initButtons()
        initEditTexts()

        // Check if voc is not null:
        if(fakultaet != null)
        {
            // setText from the passed voc object
           // etForeign.editText?.setText(fakultaet?.foreignWord)
            etNative.editText?.setText(fakultaet?.name)
        }
    }

    private fun initButtons()
    {
        btnSave = rootView.findViewById(R.id.dialog_btn_save)
        btnAbort = rootView.findViewById(R.id.dialog_btn_abort)

        btnSave.setOnClickListener { saveData() }
        btnAbort.setOnClickListener { dismiss() }
    }

    private fun initEditTexts()
    {
        etForeign = rootView.findViewById(R.id.dialog_et_foreign)
       // etNative = rootView.findViewById(R.id.dialog_et_native)
    }

    private fun saveData()
    {
        if(!TextUtils.isEmpty(etForeign.editText?.text.toString()) )
        {
            if(fakultaet != null)
            {
              //  fakultaet?.name = etNative.editText?.text.toString()
                fakultaet?.name = etForeign.editText?.text.toString()
                mainViewModel.update(fakultaet!!)
                Toast.makeText(requireContext(),"Fakultät updated in Database",Toast.LENGTH_SHORT).show()
            }
            else
            {
                mainViewModel.insert(etForeign.editText?.text.toString())
                Toast.makeText(requireContext(),"Fakultät inserted in Database",Toast.LENGTH_SHORT).show()
            }

            dismiss()
        }
        else
        {
            Toast.makeText(requireContext(),"Please insert data in both Fields!",Toast.LENGTH_SHORT).show()
        }
    }
}