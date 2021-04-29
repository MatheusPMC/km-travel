package com.acme.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

data class RespostaJSON(val message: String = "", @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm") var dataHora: Date)