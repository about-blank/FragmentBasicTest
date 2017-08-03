package com.vishal.fragmentbasictest.com.vishal.fragmentbasictest.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vishal.fragmentbasictest.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TestFragmentTwo.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TestFragmentTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestFragmentTwo extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TestFragmentTwo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestFragmentTwo.
     */
    // TODO: Rename and change types and number of parameters
    public static TestFragmentTwo newInstance(String param1, String param2) {
        TestFragmentTwo fragment = new TestFragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_test_fragment_two, container, false);

        Button sendMessageBtn = (Button) rootView.findViewById(R.id.sendMessageBtn2);
        sendMessageBtn.setOnClickListener(this);


        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setMessage(String msg) {

        ((TextView)getView().findViewById(R.id.msgTextView2)).setText("Received Msg : " + msg);
    }


    @Override
    public void onClick(View view) {

        String msg = ((EditText) getView().findViewById(R.id.msgBox2)).getText().toString().trim();
        if(!msg.isEmpty()) {
            if(mListener != null) {
                mListener.msgFromFragmentTwo(msg);
            } else {
                Toast.makeText(getContext(), "Not able to send the message to the activity !!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(), "Please provide the message to be sent !!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void msgFromFragmentTwo(String msg);
    }
}
