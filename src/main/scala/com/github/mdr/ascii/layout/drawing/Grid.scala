package com.github.mdr.ascii.layout.drawing

import com.github.mdr.ascii.parser.Region
import com.github.mdr.ascii.parser.Dimension
import com.github.mdr.ascii.parser.Point

/**
 * Array of characters used to render the final diagram
 */
class Grid(dimension: Dimension) {

  val chars: Array[Array[Char]] = Array.fill(dimension.height, dimension.width)(' ')

  def apply(point: Point): Char = chars(point.row)(point.column)

  def update(point: Point, char: Char) {
    val row = chars(point.row)
    row(point.column) = char
  }

  def update(point: Point, s: String) {
    var p = point
    for (c ← s) {
      this(p) = c
      p = p.right
    }
  }

  override def toString = chars.map(new String(_)).mkString("\n")

  private def region = Region(Point(0, 0), dimension)

  def contains(point: Point) = region.contains(point)

}