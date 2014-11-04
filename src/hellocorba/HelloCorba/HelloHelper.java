package HelloCorba;


/**
* HelloCorba/HelloHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./HelloCorba.idl
* Dienstag, 4. November 2014 14:43 Uhr MEZ
*/

abstract public class HelloHelper
{
  private static String  _id = "IDL:HelloCorba/Hello:1.0";

  public static void insert (org.omg.CORBA.Any a, HelloCorba.Hello that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static HelloCorba.Hello extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (HelloCorba.HelloHelper.id (), "Hello");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static HelloCorba.Hello read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_HelloStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, HelloCorba.Hello value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static HelloCorba.Hello narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof HelloCorba.Hello)
      return (HelloCorba.Hello)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      HelloCorba._HelloStub stub = new HelloCorba._HelloStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static HelloCorba.Hello unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof HelloCorba.Hello)
      return (HelloCorba.Hello)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      HelloCorba._HelloStub stub = new HelloCorba._HelloStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
