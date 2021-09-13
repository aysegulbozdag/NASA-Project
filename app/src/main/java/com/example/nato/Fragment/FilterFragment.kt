package com.example.nato.Fragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.nato.Interface.FilterInterface
import com.example.nato.R


class FilterFragment : AppCompatDialogFragment() {

    var chckFHAZ: CheckBox? = null;
    var chckRHAZ: CheckBox? = null;
    var chckMAST: CheckBox? = null;
    var chckCHEMCAM: CheckBox? = null;
    var chckMAHLI: CheckBox? = null;
    var chckMARDI: CheckBox? = null;
    var chckNAVCAM: CheckBox? = null;
    var chckPANCAM: CheckBox? = null;
    var chckMINITES: CheckBox? = null;
    var filterList: ArrayList<String>? = null;
    var alertDialog: AlertDialog? = null
    var listener: FilterInterface? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        val inflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.fragment_filter, null)
        defined(view)
        isCheckValue()
        builder.setView(view)
            .setTitle("deneme")
            .setPositiveButton("evet") { dialog, which ->
                Toast.makeText(
                    context,
                    android.R.string.yes, Toast.LENGTH_SHORT
                ).show()

                isCheckValue()
            }

        alertDialog = builder.create()
        alertDialog?.show()

        return (alertDialog as AlertDialog?)!!
    }

    fun isCheckValue() {
        if (chckFHAZ?.isChecked == true) {
            filterList?.add(chckFHAZ?.text.toString())
        }
        filterList?.let { listener?.getFilter(it) }

        Log.d("Response", filterList.toString())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = context as FilterInterface
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString() +
                        "must implement FilterInterface"
            )
        }
    }

    fun defined(view: View) {
        filterList = ArrayList()
        chckFHAZ = view.findViewById(R.id.chckFHAZ);
        chckRHAZ = view.findViewById(R.id.chckRHAZ);
        chckMAST = view.findViewById(R.id.chckMAST);
        chckCHEMCAM = view.findViewById(R.id.chckCHEMCAM);
        chckMAHLI = view.findViewById(R.id.chckMAHLI);
        chckMARDI = view.findViewById(R.id.chckMARDI);
        chckNAVCAM = view.findViewById(R.id.chckNAVCAM);
        chckPANCAM = view.findViewById(R.id.chckPANCAM);
        chckMINITES = view.findViewById(R.id.chckMINITES);
    }

}