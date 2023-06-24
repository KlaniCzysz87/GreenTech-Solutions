//Imports 
import scala.collection.immutable.TreeMap
import scala.collection.mutable.ListBuffer
import java.io._

//Global Variables
var energyList = ListBuffer.empty[String]

//Object
object StartUpEnergy {
  def main(args: Array[String]): Unit = {
    
    //Function - Read Energy Sources from File 
    def readEnergySource(): Unit = {
      val energyBufferedSource = scala.io.Source.fromFile("energySources.txt")
	  try 
		energyBufferedSource.getLines.foreach(line => energyList += line) 
	  finally 
		energyBufferedSource.close()	
    }
    
    //Function - Create 
    def createEnergySource(): Unit = {
      val energyFile = new File("energySources.txt")
      val energyWriter = new BufferedWriter(new FileWriter(energyFile))
      try 
		energyList.foreach(listLine => energyWriter.write(listLine + "\n"))
	  finally 
		energyWriter.close()	
    }
    
    //Function - Add Energy Source 
    def addEnergySource(energySource:String): Unit = {
      energyList += energySource
    }
    
    //Function - Remove Energy Source 
    def removeEnergySource(energySource:String): Unit = {
      energyList -= energySource
    }
    
    //Function - Create Tree Map 
    def createTreeMap(): TreeMap[String, String] = {
      var energyTreeMap = TreeMap.empty[String, String]
      for (i <- 0 until energyList.length) {
        energyTreeMap += (energyList(i) -> energyList(i))
      }
      energyTreeMap
    }
    
    //Function - Print Tree Map 
    def printTreeMap(): Unit = {
      for ((key, value) <- energyTreeMap) {
        println(s"key: $key | value: $value")
      }
    }
    
    
    //Main 
    readEnergySource()
	createEnergySource()
	addEnergySource("Solar Power")
	removeEnergySource("Oil")
	val energyTreeMap = createTreeMap()
	printTreeMap()
  }
}