package com.github.arosh.rmexe

import scalax.io._
import scalax.file._

import scala.Console.err

object Main extends App {
  val files = Path(".") children () filter { file =>
    // 実行可能ファイルである
    if (file.isFile && file.canExecute) true
    // デバッグ情報の入ったディレクトリである
    else if (file.isDirectory && file.name.matches("""^.+\.dSYM$""")) true
    else false
  }

  if(files.isEmpty) sys.exit()

  err.println("candidate for delete")
  err.println("-" * 10)

  err.println(files map { _.name } mkString("\n"))

  err.println("-" * 10)

  err.print("delete all? (y/n [n]) ")

  try {
    val c = readChar()
    c match {
      case 'y' => {
        files.foreach { file =>
          file.deleteRecursively()
        }

        err.println("file deleted")
      }

      case _ => err.println("not deleted")
    }
  }
  catch {
    case _ =>
  }
}
