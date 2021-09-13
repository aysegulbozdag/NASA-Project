package com.example.nato.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nato.Adapter.DataAdapter
import com.example.nato.Model.RetrofitModel.PhotoModel
import com.example.nato.R
import com.example.simpleretrofitexample.MainViewModel.MainViewModel
import com.example.simpleretrofitexample.MainViewModel.MainViewModelFactory
import com.example.simpleretrofitexample.Repository.Repository

class SpritFragment : Fragment() {

    private var rv: RecyclerView? = null;
    private var ivFilter: ImageView? = null;
    private var gridLayoutManager: GridLayoutManager? = null;
    private var arrayList: ArrayList<PhotoModel?> = ArrayList();
    private var dataAdapter: DataAdapter? = null;
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_opportunity2, container, false);
        rv = view.findViewById(R.id.rvopportunity);
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getSplit()
        viewModel.responseCameraModel.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {

                response.body()?.photoList?.forEach { photoModel -> arrayList.add(photoModel) }
                Log.d("Response", response.body()?.photoList?.get(0)?.camera?.name.toString())
                Log.d("Response", response.body().toString())
                gridLayoutManager =
                    GridLayoutManager(context, 3, LinearLayoutManager.VERTICAL, false)
                rv?.layoutManager = gridLayoutManager;
                rv?.setHasFixedSize(true)
                dataAdapter = DataAdapter(requireContext(), arrayList)
                rv?.adapter = dataAdapter

            } else {
                Log.d("ResponseError", response.errorBody().toString())
            }
        })


        return view;
    }


}