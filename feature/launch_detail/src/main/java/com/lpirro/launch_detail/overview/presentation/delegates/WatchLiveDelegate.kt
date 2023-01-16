package com.lpirro.launch_detail.overview.presentation.delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.lpirro.core.extensions.show
import com.lpirro.launch_detail.databinding.ItemWatchliveBinding
import com.lpirro.launch_detail.overview.model.LaunchOverviewItem
import com.lpirro.launch_detail.overview.model.WatchLiveUi
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

fun watchLiveDelegate(fullScreenClickListener: (String) -> Unit) =
    adapterDelegateViewBinding<WatchLiveUi, LaunchOverviewItem, ItemWatchliveBinding>(
        { layoutInflater, root -> ItemWatchliveBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    item.youtubeVideoId.let { youTubePlayer.cueVideo(it, 0f) }
                }

                override fun onStateChange(
                    youTubePlayer: YouTubePlayer,
                    state: PlayerConstants.PlayerState
                ) {
                    if (state == PlayerConstants.PlayerState.PLAYING) {
                        binding.watchFullScreenButton.show()
                    }
                }
            })

            binding.watchFullScreenButton.setOnClickListener {
                fullScreenClickListener.invoke(item.youtubeVideoId)
            }
        }
    }
