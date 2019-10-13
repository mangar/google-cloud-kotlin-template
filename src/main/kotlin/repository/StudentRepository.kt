package main.kotlin.repository

import br.com.mangar.App
import com.google.api.services.sheets.v4.model.ValueRange
import main.kotlin.SpreadSheetDataSource
import main.kotlin.model.*
import main.kotlin.stringFor


class StudentRepository :
  SpreadSheetDataSource("1MS2uJSEOsvA04UV7hkc9ub8fEKNS-T1Z37IocuWPHPo", "students!A:C"){

  /**
   * TODO: Implement Cache for this call
   */
  fun listAll(): List<Student> = getAll.execute().getValues()
      .toRawEntries()
      .map { it.toRanking() }

  fun add(student: Student) {


    App.logInfo("Add Registro na tabela...1")

    //
    // Read Data from Spreadsheet
    //
    val response = sheets.spreadsheets().values()
        .get("1MS2uJSEOsvA04UV7hkc9ub8fEKNS-T1Z37IocuWPHPo", "students!A:D")
        .execute()

    val values = response.getValues()

    App.logInfo(">> Values: $values")

    val count = values.size
    App.logInfo(">> Size: $count")


    //
    // Add Record
    //
    val newRowId = count + 1
    val newRecord = ValueRange().setValues( listOf(listOf<Any>("${student.name} - ${newRowId}",
                                                               "${student.email} - ${newRowId}",
                                                               "${student.username} - ${newRowId}",
                                                               "${student.createdAt}")))

    sheets.spreadsheets().values()
      .update("1MS2uJSEOsvA04UV7hkc9ub8fEKNS-T1Z37IocuWPHPo", "students!A$newRowId:D$newRowId", newRecord)
      .setValueInputOption("RAW")
      .execute()



    App.logInfo("Add Registro na tabela... 2")



  }
}


private fun List<List<Any>>.toRawEntries(): List<Map<String, Any>> {
  val headers = first().map { it as String }
  val rows = drop(1)
  return rows.map { row -> headers.zip(row).toMap() }
}


private fun Map<String, Any>.toRanking() = Student(
  name = stringFor("name"),
  email = stringFor("email"),
  username = stringFor("username")
)
