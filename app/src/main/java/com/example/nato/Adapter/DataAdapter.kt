package com.example.nato.Adapter

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nato.Model.RetrofitModel.PhotoModel
import com.example.nato.Object.Constant
import com.example.nato.R

class DataAdapter(var context: Context, var arrayList: ArrayList<PhotoModel?>) :
    RecyclerView.Adapter<DataAdapter.ItemHolder>() {
    var dialog: Dialog? = null;

    override fun getItemViewType(position: Int): Int {
        return if (arrayList[position] == null) {
            Constant.VIEW_TYPE_LOADING
        } else {
            Constant.VIEW_TYPE_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.ItemHolder {
        context = parent.context

        val itemHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.data_layout, parent, false)
        dialog = Dialog(context)
        return ItemHolder(itemHolder);


    }

    override fun onBindViewHolder(holder: DataAdapter.ItemHolder, position: Int) {

        val model: PhotoModel = arrayList.get(position)!!

        //Normal item
        var holder: ItemHolder = holder as ItemHolder
        //burada işlem olarak text içeriğini değiştiriyoruz
        Glide.with(context)
            .load(model.img_src)
            .into(holder.icons)
        holder.icons.setOnClickListener {
            dialog?.setContentView(R.layout.dialog);
            val iv: ImageView? = dialog?.findViewById(R.id.idPopupIv)
            val txtName: TextView? = dialog?.findViewById(R.id.txtName)
            val txtCameraName: TextView? = dialog?.findViewById(R.id.txtCameraName)
            val txtTaskState: TextView? = dialog?.findViewById(R.id.txtTaskState)
            val txtDateTaken: TextView? = dialog?.findViewById(R.id.txtDateTaken)
            val txtLanding: TextView? = dialog?.findViewById(R.id.txtLanding)
            val txtLaunching: TextView? = dialog?.findViewById(R.id.txtLaunching)
            val txtClose: TextView? = dialog?.findViewById(R.id.txtclose)

            if (iv != null && txtName != null && txtCameraName != null
                && txtTaskState != null && txtDateTaken != null
                && txtLanding != null && txtLaunching != null && txtClose != null
            ) {
                Glide.with(context)
                    .load(model.img_src)
                    .into(iv)

                txtName.setText(model.rover?.name)
                txtCameraName.setText(model.camera?.name)
                txtTaskState.setText(model.rover?.status)
                txtDateTaken.setText(model.earth_date)
                txtLanding.setText(model.rover?.landing_date)
                txtLaunching.setText(model.rover?.launch_date)

                txtClose.setOnClickListener {
                    dialog?.dismiss()
                }
            }




            dialog?.show()
        }

    }

    override fun getItemCount(): Int {
        return arrayList.size;
    }


    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icons: ImageView = itemView.findViewById(R.id.iv);

    }

}