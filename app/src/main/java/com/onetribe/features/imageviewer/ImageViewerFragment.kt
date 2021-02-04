package com.onetribe.features.imageviewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.onetribe.base.NavDestination
import com.onetribe.R
import dev.hotwire.turbo.fragments.TurboFragment
import dev.hotwire.turbo.nav.TurboNavGraphDestination
import com.bumptech.glide.Glide
import com.onetribe.util.displayBackButtonAsCloseIcon

@TurboNavGraphDestination(uri = "turbo://fragment/image_viewer")
class ImageViewerFragment : TurboFragment(), NavDestination {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image_viewer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initToolbar()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadImage(view)
    }

    private fun initToolbar() {
        toolbarForNavigation()?.displayBackButtonAsCloseIcon()
    }

    private fun loadImage(view: View) {
        view.findViewById<ImageView>(R.id.image_view)?.let {
            Glide.with(this).load(location).into(it)
        }
    }
}
