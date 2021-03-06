import scala.language.implicitConversions
import scala.language.reflectiveCalls

object Test extends dotty.runtime.LegacyApp {
  trait Foo[A]
  implicit def fooString: Foo[String] = null
  implicit def value[A](implicit foo: Foo[A]): Int = 5

  println(implicitly[Int])

  implicit def conversion[A](x: Int)(implicit foo: Foo[A]): AnyRef{def aMethod: Int} = new {
    def aMethod = 5
  }
  println(1.aMethod)
}
