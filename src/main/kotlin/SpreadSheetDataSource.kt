package main.kotlin

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.sheets.v4.Sheets

open class SpreadSheetDataSource (val spreadsheet: String, val range: String) {

  private val transport = GoogleNetHttpTransport.newTrustedTransport()
  private val jacksonFactory = JacksonFactory.getDefaultInstance()
  val sheets: Sheets = Sheets.Builder(transport, jacksonFactory, AppCredentials.local).build()

  val getAll = sheets.spreadsheets().values().get(this.spreadsheet, this.range)!!

}

fun Map<String, Any>.stringFor(key: String) = (this[key] as? String) ?: ""
fun Map<String, Any>.intFor(key: String) = stringFor(key).toIntOrNull() ?: -1
