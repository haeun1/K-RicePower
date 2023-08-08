package com.example.familyalbum

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.example.familyalbum.databinding.FragmentChatBinding
import com.example.familyalbum.databinding.FragmentProfileBinding
import com.example.familyalbum.databinding.FragmentTimeTableBinding


class TimeTableFragment : Fragment() {

    private lateinit var binding: FragmentTimeTableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimeTableBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        schedule()
    }

    fun schedule() {
        val parentView = binding.monView // db에 따라 다르게

        // 사용자 정의 레이아웃을 인플레이션
        val inflater = LayoutInflater.from(context)
        val customLayout: View = inflater.inflate(R.layout.schedule, parentView, false)

        // 원하는대로 레이아웃 매개변수를 설정
        val layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT, // 부모의 전체 너비 사용
            500  // 높이를 레이아웃의 내용에 맞게 조정, 높이는 starttime과 endtime으로 적절한 비율로 계산
        ).apply {
            topMargin = 50  // 상단에서의 거리(시작위치), starttime에 따라 달라질 것
        }
        customLayout.layoutParams = layoutParams
        val start: TextView = customLayout.findViewById(R.id.start)
        start.text = "9"
        val end: TextView = customLayout.findViewById(R.id.end)
        end.text = "13"
        val name: TextView = customLayout.findViewById(R.id.name)
        name.text = "이벤트1"
        val place: TextView = customLayout.findViewById(R.id.place)
        place.text = "장소1"


        parentView.addView(customLayout)  // 인플레이션 된 사용자 정의 레이아웃을 부모 뷰에 추가
    }


}