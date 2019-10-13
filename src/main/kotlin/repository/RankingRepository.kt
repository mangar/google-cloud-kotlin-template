package main.kotlin.repository

import main.kotlin.SpreadSheetDataSource
import main.kotlin.intFor
import main.kotlin.model.Ranking
import main.kotlin.stringFor


class RankingRepository :
  SpreadSheetDataSource("1MS2uJSEOsvA04UV7hkc9ub8fEKNS-T1Z37IocuWPHPo", "ranking!A:C"){

  /**
   * TODO: Implement Cache for this call
   */
  fun listAll(): List<Ranking> = getAll.execute().getValues()
      .toRawEntries()
      .map { it.toRanking() }
}


private fun List<List<Any>>.toRawEntries(): List<Map<String, Any>> {
  val headers = first().map { it as String }
  val rows = drop(1)
  return rows.map { row -> headers.zip(row).toMap() }
}


private fun Map<String, Any>.toRanking() = Ranking(
  position = intFor("position"),
  username = stringFor("username"),
  points = intFor("points")
)

