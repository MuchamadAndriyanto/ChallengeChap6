package com.example.bismillahjadi.model

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class ResultTest {

    private lateinit var result: Result

    @Before
    fun setUp() {
        // Persiapan sebelum setiap pengujian dilakukan
        MockitoAnnotations.openMocks(this)

        // Membuat objek Result dengan nilai-nilai yang diberikan
        result = Result(
            false,
            "backdropPath",
            listOf(1, 2, 3),
            123,
            "originalLanguage",
            "originalTitle",
            "overview",
            4.5,
            "posterPath",
            "2023-05-31",
            "title",
            true,
            7.8,
            100
        )
    }

    @After
    fun tearDown() {
        // Membersihkan setelah setiap pengujian selesai
    }

    @Test
    fun testResultProperties() {
        // Persiapan data yang diperlukan untuk pengujian

        // Verifikasi nilai-nilai properti dalam kelas Result
        assert(result.adult == false)
        assert(result.backdropPath == "backdropPath")
        assert(result.genreIds == listOf(1, 2, 3))
        assert(result.id == 123)
        assert(result.originalLanguage == "originalLanguage")
        assert(result.originalTitle == "originalTitle")
        assert(result.overview == "overview")
        assert(result.popularity == 4.5)
        assert(result.posterPath == "posterPath")
        assert(result.releaseDate == "2023-05-31")
        assert(result.title == "title")
        assert(result.video == true)
        assert(result.voteAverage == 7.8)
        assert(result.voteCount == 100)
    }
}