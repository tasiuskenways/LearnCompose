package com.tasius.learn.component.ImageCard.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageCardData(
    var path: String,
    var contentDescription: String,
    var title: String
)
