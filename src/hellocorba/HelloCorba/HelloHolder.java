package HelloCorba;

/**
* HelloCorba/HelloHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./HelloCorba.idl
* Dienstag, 4. November 2014 14:43 Uhr MEZ
*/

public final class HelloHolder implements org.omg.CORBA.portable.Streamable
{
  public HelloCorba.Hello value = null;

  public HelloHolder ()
  {
  }

  public HelloHolder (HelloCorba.Hello initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = HelloCorba.HelloHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    HelloCorba.HelloHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return HelloCorba.HelloHelper.type ();
  }

}
