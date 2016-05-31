package io.github.nthportal.euler.util

import java.util

import io.github.nthportal.euler.util.TriangleGraph._
import org.jgrapht.alg.interfaces.AStarAdmissibleHeuristic
import org.jgrapht.{DirectedGraph, EdgeFactory}

import scala.collection.JavaConversions

final class TriangleGraph(triangle: List[List[Int]]) extends DirectedGraph[Vertex, Edge] {
  val heuristicPerDistanceUnit = 1
  val heuristic = new AStarAdmissibleHeuristic[Vertex] {
    override def getCostEstimate(sourceVertex: Vertex, targetVertex: Vertex): Double = sourceVertex.heuristicFrom
  }

  val root: Vertex = VertexImpl(0, 0)

  def goal: Vertex = FakeVertex

  override def incomingEdgesOf(vertex: Vertex): util.Set[Edge] = ???

  override def outDegreeOf(vertex: Vertex): Int = outgoingEdgesOf(vertex).size

  override def outgoingEdgesOf(vertex: Vertex): util.Set[Edge] = {
    JavaConversions.setAsJavaSet(vertex.adjacent.map(EdgeImpl(vertex, _)))
  }

  override def inDegreeOf(vertex: Vertex): Int = ???

  /* DirectedGraph methods */

  override def getEdge(sourceVertex: Vertex, targetVertex: Vertex): Edge = EdgeImpl(sourceVertex, targetVertex)

  override def removeAllEdges(edges: util.Collection[_ <: Edge]): Boolean = unsupported()

  override def removeAllEdges(sourceVertex: Vertex, targetVertex: Vertex): util.Set[Edge] = unsupported()

  override def getEdgeFactory: EdgeFactory[Vertex, Edge] = unsupported()

  override def edgesOf(vertex: Vertex): util.Set[Edge] = ???

  override def containsEdge(sourceVertex: Vertex, targetVertex: Vertex): Boolean = ???

  override def containsEdge(e: Edge): Boolean = true

  override def edgeSet(): util.Set[Edge] = ???

  override def getAllEdges(sourceVertex: Vertex, targetVertex: Vertex): util.Set[Edge] = ???

  override def addEdge(sourceVertex: Vertex, targetVertex: Vertex): Edge = unsupported()

  private def unsupported() = throw new UnsupportedOperationException

  override def addEdge(sourceVertex: Vertex, targetVertex: Vertex, e: Edge): Boolean = unsupported()

  override def containsVertex(v: Vertex): Boolean = true

  override def getEdgeTarget(e: Edge): Vertex = e.target

  override def getEdgeSource(e: Edge): Vertex = e.source

  override def removeVertex(v: Vertex): Boolean = unsupported()

  override def vertexSet(): util.Set[Vertex] = ???

  override def addVertex(v: Vertex): Boolean = unsupported()

  override def getEdgeWeight(e: Edge): Double = e.target.value

  override def removeEdge(sourceVertex: Vertex, targetVertex: Vertex): Edge = unsupported()

  override def removeEdge(e: Edge): Boolean = unsupported()

  override def removeAllVertices(vertices: util.Collection[_ <: Vertex]): Boolean = unsupported()

  case class VertexImpl private(row: Int, col: Int) extends Vertex {
    triangle(row)(col)

    // Lazy bounds check :P

    override def adjacent: Set[Vertex] = {
      row match {
        case x if x == (triangle.length - 1) => FakeVertex.set
        case _ => Set(VertexImpl(row + 1, col), VertexImpl(row + 1, col + 1))
      }
    }

    override def triangleValue: Int = triangle(row)(col)

    override def heuristicFrom: Int = heuristicPerDistanceUnit * (triangle.length - row)
  }

  case class EdgeImpl private(source: Vertex, target: Vertex) extends Edge {
    assert(source.adjacent contains target)

    override def weight: Int = target.value
  }

  private object FakeVertex extends Vertex {
    val set: Set[Vertex] = Set(this)

    override def adjacent: Set[Vertex] = Set.empty

    override def triangleValue: Int = 0

    override def value: Int = 0

    override def heuristicFrom: Int = 0

    override def equals(obj: scala.Any): Boolean = {
      obj match {
        case rhs: AnyRef => this eq rhs
        case _ => false
      }
    }

    override def hashCode: Int = 0
  }

}

object TriangleGraph {
  private val maxVal = 100

  sealed trait Vertex {
    def adjacent: Set[Vertex]

    def triangleValue: Int

    def value: Int = maxVal - triangleValue

    def heuristicFrom: Int
  }

  sealed trait Edge {
    def source: Vertex

    def target: Vertex

    def weight: Int
  }

}
