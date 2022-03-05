package com.self_development.ba_iac.mainfuntion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.self_development.ba_iac.R
import com.self_development.ba_iac.databinding.FragmentCommunityBinding
import com.self_development.ba_iac.databinding.FragmentRaidBossBinding

class raidBossFragment : Fragment() {

    private var _binding: FragmentRaidBossBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRaidBossBinding.inflate(inflater, container, false)

        binding.profileTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_raidBossFragment_to_studentProfileFragment)
        }

        binding.organizeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_raidBossFragment_to_organizeFragment)
        }

        binding.communityTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_raidBossFragment_to_communityFragment)
        }

        binding.questTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_raidBossFragment_to_questFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}