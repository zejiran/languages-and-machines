// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/Utilities.gold"
import gold.*;
import gold.structures.*;
import gold.structures.automaton.*;
import gold.structures.bag.*;
import gold.structures.collection.*;
import gold.structures.deque.*;
import gold.structures.disjointset.*;
import gold.structures.graph.*;
import gold.structures.heap.*;
import gold.structures.list.*;
import gold.structures.map.*;
import gold.structures.multimap.*;
import gold.structures.point.*;
import gold.structures.queue.*;
import gold.structures.set.*;
import gold.structures.stack.*;
import gold.structures.tree.*;
import gold.structures.tree.binary.*;
import gold.structures.tree.nary.*;
import gold.structures.tuple.*;
import gold.structures.turingMachine.*;
import gold.swing.*;
import gold.swing.icon.*;
import gold.swing.icon.ajaxload.*;
import gold.swing.icon.famfamfam.*;
import gold.swing.icon.gold.*;
import gold.swing.icon.jlfgr.*;
import gold.swing.icon.wikimedia.*;
import gold.swing.icon.windows.*;
import gold.swing.look.*;
import gold.swing.util.*;
import gold.test.*;
import gold.test.automaton.*;
import gold.test.general.*;
import gold.test.graph.*;
import gold.util.*;
import gold.visualization.*;
import gold.visualization.automaton.*;
import gold.visualization.graph.*;
import gold.visualization.quadtree.*;
import gold.visualization.turingMachine.*;
import gold.visualization.util.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class Utilities {
  public static Object toSet(Object C) {
    int $line=0;
    Object $result=null;
    $try:try {
      gold.structures.set.ISet $v1=$newSet();
      $v2:for (Object x:GCollections.unmodifiableCollection(C)) {
        $v1.add(x);
      }
      $result=$v1;
      if (true) break $try;
      $line=3;
      $rethrow(new RuntimeException("The function \"toSet(C:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Utilities.class,"toSet",$line);
    }
    return $result;
  }
  public static Object reverse(String s) {
    int $line=0;
    Object $result=null;
    $try:try {
      $result=$invokeMethod("toString",$invokeMethod("reverse",$invokeConstructor(StringBuilder.class,new Object[]{s}),new Object[]{}),new Object[]{});
      if (true) break $try;
      $line=5;
      $rethrow(new RuntimeException("The function \"reverse(s:String)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Utilities.class,"reverse",$line);
    }
    return $result;
  }
  public static Object testBlock(IAutomaton M, Object testCases) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=9;
      java.util.Scanner sc=null;
      sc=$invokeConstructor(java.util.Scanner.class,new Object[]{$invokeField(System.class,"in",true,null)});
      $line=10;
      Object isTransducer=$fix($invokeMethod("isInstance",$invokeField(ITransducer.class,"class",true,null),new Object[]{M}));
      $line=12;
      for (Object $v3:GCollections.unmodifiableCollection(testCases)) {
        java.util.Iterator $v4=GCollections.unmodifiableCollection($v3).iterator();
        Object s=$v4.next();
        Object r=$v4.next();
        $line=13;
        Object result=$fix(((gold.structures.automaton.IAutomaton)M).acceptsString($cast(java.lang.String.class,s)));
        $line=14;
        Object t=$fix((($bool($opEqualY(s,"")))?("\u03BB"):(s)));
        $line=15;
        if (($opEqualY(r,result)&&$bool(result))) {
          $line=16;
          System.out.println($message(new Object[]{$opAdditY($opAdditY("String: ",t)," was correctly accepted")}));
        }
        else {
          $line=17;
          if ($opEqualY(r,result)) {
            $line=18;
            System.out.println($message(new Object[]{$opAdditY($opAdditY("String: ",t)," was correctly rejected")}));
          }
          else {
            $line=19;
            if ($bool(result)) {
              $line=20;
              System.out.println($message(new Object[]{$opAdditY($opAdditY("String: ",t)," was incorrectly accepted")}));
            }
            else {
              $line=22;
              System.out.println($message(new Object[]{$opAdditY($opAdditY("String: ",t)," was incorrectly rejected")}));
            }
          }
        }
      }
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Utilities.class,"testBlock",$line);
    }
    return $result;
  }
  public static Object test(IAutomaton M, String add, Boolean rev) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=34;
      java.util.Scanner sc=null;
      sc=$invokeConstructor(java.util.Scanner.class,new Object[]{$invokeField(System.class,"in",true,null)});
      $line=35;
      Object isTransducer=$fix($invokeMethod("isInstance",$invokeField(ITransducer.class,"class",true,null),new Object[]{M}));
      $line=36;
      while (true) {
        if (!($bool(true))) break;
        $line=37;
        System.out.println($message(new Object[]{"----------------------------"}));
        $line=38;
        System.out.println($message(new Object[]{"Input String (empty string to exit): "}));
        $line=40;
        Object string=$fix(((java.util.Scanner)sc).nextLine());
        $line=41;
        if ($opEqualY(string,"")) {
          $line=41;
          break;
        }
        $line=43;
        Object inputM=$fix(Utilities.toSet(((gold.structures.automaton.IAutomaton)M).getAlphabet()));
        $line=45;
        if ($bool(rev)) {
          $line=46;
          string=$fix(Utilities.reverse($cast(java.lang.String.class,string)));
          $line=47;
          System.out.println($message(new Object[]{$opAdditY("reverse: ",string)}));
        }
        $line=49;
        string=$fix($opAdditY(string,add));
        $line=50;
        if ($bool($invokeMethod("containsAll",((gold.structures.automaton.IAutomaton)M).getAlphabet(),new Object[]{string}))) {
          $line=52;
          Object result=$fix(((gold.structures.automaton.IAutomaton)M).acceptsString($cast(java.lang.String.class,string)));
          $line=54;
          System.out.println($message(new Object[]{$opAdditY($opAdditY("The string was ",(($bool(result))?("accepted!"):("rejected."))),(($bool(isTransducer))?(". Output:"):("")))}));
          $line=55;
          if ($bool(isTransducer)) {
            $line=56;
            System.out.println($message(new Object[]{$invokeMethod("getOutputString",$cast(ITransducer.class,M),new Object[]{})}));
            $line=57;
            if ($bool(rev)) {
              $line=57;
              System.out.println($message(new Object[]{$opAdditY("reverse: ",Utilities.reverse($cast(java.lang.String.class,$invokeMethod("getOutputString",$cast(ITransducer.class,M),new Object[]{}))))}));
            }
          }
        }
        else {
          $line=60;
          System.out.println($message(new Object[]{$opAdditY("Input contains invalid symbols: ",$opDiffeY(Utilities.toSet(string),inputM))}));
        }
      }
      $line=63;
      System.out.println($message(new Object[]{"Execution terminated"}));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Utilities.class,"test",$line);
    }
    return $result;
  }
  public static Object test(IAutomaton M) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=68;
      java.util.Scanner sc=null;
      sc=$invokeConstructor(java.util.Scanner.class,new Object[]{$invokeField(System.class,"in",true,null)});
      $line=69;
      Object isTransducer=$fix($invokeMethod("isInstance",$invokeField(ITransducer.class,"class",true,null),new Object[]{M}));
      $line=70;
      while (true) {
        if (!($bool(true))) break;
        $line=71;
        System.out.println($message(new Object[]{"----------------------------"}));
        $line=72;
        System.out.println($message(new Object[]{"Input String (empty string to exit): "}));
        $line=74;
        Object string=$fix(((java.util.Scanner)sc).nextLine());
        $line=75;
        if ($opEqualY(string,"")) {
          $line=75;
          break;
        }
        $line=77;
        Object inputM=$fix(Utilities.toSet(((gold.structures.automaton.IAutomaton)M).getAlphabet()));
        $line=79;
        if ($bool($invokeMethod("containsAll",((gold.structures.automaton.IAutomaton)M).getAlphabet(),new Object[]{string}))) {
          $line=80;
          Object result=$fix(((gold.structures.automaton.IAutomaton)M).acceptsString($cast(java.lang.String.class,string)));
          $line=81;
          System.out.println($message(new Object[]{$opAdditY($opAdditY("The string was ",(($bool(result))?("accepted!"):("rejected."))),(($bool(isTransducer))?(". Output:"):("")))}));
          $line=82;
          if ($bool(isTransducer)) {
            $line=83;
            System.out.println($message(new Object[]{$invokeMethod("getOutputString",$cast(ITransducer.class,M),new Object[]{})}));
          }
        }
        else {
          $line=86;
          System.out.println($message(new Object[]{$opAdditY("Input contains invalid symbols: ",$opDiffeY(Utilities.toSet(string),inputM))}));
        }
      }
      $line=89;
      System.out.println($message(new Object[]{"Execution terminated"}));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Utilities.class,"test",$line);
    }
    return $result;
  }
  public static Object testR(IAutomaton M) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=94;
      java.util.Scanner sc=null;
      sc=$invokeConstructor(java.util.Scanner.class,new Object[]{$invokeField(System.class,"in",true,null)});
      $line=95;
      Object isTransducer=$fix($invokeMethod("isInstance",$invokeField(ITransducer.class,"class",true,null),new Object[]{M}));
      $line=96;
      while (true) {
        if (!($bool(true))) break;
        $line=97;
        System.out.println($message(new Object[]{"----------------------------"}));
        $line=98;
        System.out.println($message(new Object[]{"Input String (empty string to exit): "}));
        $line=100;
        Object string=$fix(((java.util.Scanner)sc).nextLine());
        $line=101;
        if ($opEqualY(string,"")) {
          $line=101;
          break;
        }
        $line=103;
        Object inputM=$fix(Utilities.toSet(((gold.structures.automaton.IAutomaton)M).getAlphabet()));
        $line=105;
        if ($bool($invokeMethod("containsAll",((gold.structures.automaton.IAutomaton)M).getAlphabet(),new Object[]{string}))) {
          $line=106;
          Object result=$fix(((gold.structures.automaton.IAutomaton)M).acceptsString($cast(java.lang.String.class,$opAdditY(Utilities.reverse($cast(java.lang.String.class,string)),"$"))));
          $line=107;
          System.out.println($message(new Object[]{$opAdditY($opAdditY("The string was ",(($bool(result))?("accepted!"):("rejected."))),(($bool(isTransducer))?(". Output:"):("")))}));
          $line=108;
          if ($bool(isTransducer)) {
            $line=109;
            System.out.println($message(new Object[]{Utilities.reverse($cast(java.lang.String.class,$invokeMethod("getOutputString",$cast(ITransducer.class,M),new Object[]{})))}));
          }
        }
        else {
          $line=112;
          System.out.println($message(new Object[]{$opAdditY("Input contains invalid symbols: ",$opDiffeY(Utilities.toSet(string),inputM))}));
        }
      }
      $line=115;
      System.out.println($message(new Object[]{"Execution terminated"}));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Utilities.class,"testR",$line);
    }
    return $result;
  }
  public static Object testCodeDecodeRevAddDS(ITransducer C, ITransducer D) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=120;
      java.util.Scanner sc=null;
      sc=$invokeConstructor(java.util.Scanner.class,new Object[]{$invokeField(System.class,"in",true,null)});
      $line=122;
      Object inputC=$fix(Utilities.toSet(((gold.structures.automaton.ITransducer)C).getInputAlphabet()));
      $line=123;
      Object inputD=$fix(Utilities.toSet(((gold.structures.automaton.ITransducer)D).getInputAlphabet()));
      $line=125;
      System.out.println($message(new Object[]{"Testing Coder- Reverse Decoder"}));
      $line=126;
      Object string=$fix(" ");
      $line=127;
      boolean $v5=false;
      while (true) {
        if ($v5) {
          if ($bool(false)) break;
        }
        $v5=true;
        $line=128;
        System.out.println($message(new Object[]{"----------------------------"}));
        $line=129;
        System.out.println($message(new Object[]{"Input string: (empty string to end)"}));
        $line=131;
        string=$fix(((java.util.Scanner)sc).nextLine());
        $line=132;
        if ($opEqualY(string,"")) {
          $line=132;
          break;
        }
        else {
          $line=134;
          Object option=$fix("");
          $line=135;
          while (true) {
            if (!(!$opMembrY(option,GCollections.asSet("1","2","3")))) break;
            $line=136;
            System.out.println($message(new Object[]{"What do you want to do?"}));
            $line=137;
            System.out.println($message(new Object[]{"1. code only?"}));
            $line=138;
            System.out.println($message(new Object[]{"2. code and decode (rev)?"}));
            $line=139;
            System.out.println($message(new Object[]{"3. decode only (rev)?"}));
            $line=141;
            option=$fix(((java.util.Scanner)sc).nextLine());
          }
          $line=143;
          Object stringOut=$fix("");
          $line=145;
          if (($opEqualY(option,"1")||$opEqualY(option,"2"))) {
            $line=147;
            if ($opSbsetY(Utilities.toSet(string),inputC)) {
              $line=148;
              Object result=$fix(((gold.structures.automaton.ITransducer)C).acceptsString($cast(java.lang.String.class,$opAdditY(string,"$"))));
              $line=149;
              System.out.println($message(new Object[]{$opAdditY($opAdditY($opAdditY("The string was ",(($bool(result))?("accepted"):("not accepted"))),". Output: "),((gold.structures.automaton.ITransducer)C).getOutputString())}));
              $line=150;
              stringOut=$fix(((gold.structures.automaton.ITransducer)C).getOutputString());
              $line=151;
              if ($opEqualY(option,"2")) {
                $line=152;
                if ($opSbsetY(Utilities.toSet(stringOut),inputD)) {
                  $line=154;
                  result=$fix(((gold.structures.automaton.ITransducer)D).acceptsString($cast(java.lang.String.class,$opAdditY(Utilities.reverse($cast(java.lang.String.class,stringOut)),"$"))));
                  $line=155;
                  Object stringOut1R=$fix(Utilities.reverse($cast(java.lang.String.class,((gold.structures.automaton.ITransducer)D).getOutputString())));
                  $line=157;
                  System.out.println($message(new Object[]{$opAdditY($opAdditY($opAdditY("The Reverse of the coded string was ",(($bool(result))?("accepted"):("not accepted"))),". Output: "),Utilities.reverse($cast(java.lang.String.class,((gold.structures.automaton.ITransducer)D).getOutputString())))}));
                  $line=158;
                  System.out.println($message(new Object[]{$opAdditY($opAdditY("The Reverse of the decoded string is ",((!$opEqualY(stringOut1R,string))?("not "):(""))),"equal to the original string.")}));
                }
                else {
                  $line=160;
                  System.out.println($message(new Object[]{$opAdditY("Output contains invalid symbols for the decoder: ",$opDiffeY(Utilities.toSet(stringOut),inputD))}));
                }
              }
            }
            else {
              $line=165;
              System.out.println($message(new Object[]{$opAdditY("Input contains invalid symbols: ",$opDiffeY(Utilities.toSet(string),inputC))}));
            }
          }
          else {
            $line=168;
            if ($opSbsetY(Utilities.toSet(string),inputD)) {
              $line=169;
              Object result=$fix(((gold.structures.automaton.ITransducer)D).acceptsString($cast(java.lang.String.class,$opAdditY(Utilities.reverse($cast(java.lang.String.class,string)),"$"))));
              $line=170;
              System.out.println($message(new Object[]{$opAdditY($opAdditY($opAdditY("The string was ",(($bool(result))?("accepted"):("not accepted")))," by the decoder. Output: "),Utilities.reverse($cast(java.lang.String.class,((gold.structures.automaton.ITransducer)D).getOutputString())))}));
            }
            else {
              $line=172;
              System.out.println($message(new Object[]{$opAdditY("Input contains invalid symbols: ",$opDiffeY(Utilities.toSet(string),inputD))}));
            }
          }
        }
      }
      $line=179;
      System.out.println($message(new Object[]{"Execution Ended"}));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Utilities.class,"testCodeDecodeRevAddDS",$line);
    }
    return $result;
  }
  public static Object testCodeDecode(ITransducer C, ITransducer D) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=184;
      java.util.Scanner sc=null;
      sc=$invokeConstructor(java.util.Scanner.class,new Object[]{$invokeField(System.class,"in",true,null)});
      $line=186;
      Object inputC=$fix(Utilities.toSet(((gold.structures.automaton.ITransducer)C).getInputAlphabet()));
      $line=187;
      Object inputD=$fix(Utilities.toSet(((gold.structures.automaton.ITransducer)D).getInputAlphabet()));
      $line=189;
      System.out.println($message(new Object[]{"Testing Coder-Decoder"}));
      $line=190;
      Object string=$fix(" ");
      $line=191;
      boolean $v6=false;
      while (true) {
        if ($v6) {
          if ($bool(false)) break;
        }
        $v6=true;
        $line=192;
        System.out.println($message(new Object[]{"----------------------------"}));
        $line=193;
        System.out.println($message(new Object[]{"Input string: (empty string to end)"}));
        $line=195;
        string=$fix(((java.util.Scanner)sc).nextLine());
        $line=196;
        if ($opEqualY(string,"")) {
          $line=196;
          break;
        }
        else {
          $line=198;
          Object option=$fix("");
          $line=199;
          while (true) {
            if (!(!$opMembrY(option,GCollections.asSet("1","2","3")))) break;
            $line=200;
            System.out.println($message(new Object[]{"What do you want to do?"}));
            $line=201;
            System.out.println($message(new Object[]{"1. code only?"}));
            $line=202;
            System.out.println($message(new Object[]{"2. code and decode?"}));
            $line=203;
            System.out.println($message(new Object[]{"3. decode only?"}));
            $line=205;
            option=$fix(((java.util.Scanner)sc).nextLine());
          }
          $line=207;
          Object stringOut=$fix("");
          $line=208;
          if (($opEqualY(option,"1")||$opEqualY(option,"2"))) {
            $line=210;
            if ($opSbsetY(Utilities.toSet(string),inputC)) {
              $line=211;
              Object result=$fix(((gold.structures.automaton.ITransducer)C).acceptsString($cast(java.lang.String.class,string)));
              $line=212;
              System.out.println($message(new Object[]{$opAdditY($opAdditY($opAdditY("The string was ",(($bool(result))?("accepted"):("not accepted"))),". Output: "),((gold.structures.automaton.ITransducer)C).getOutputString())}));
              $line=213;
              stringOut=$fix(((gold.structures.automaton.ITransducer)C).getOutputString());
              $line=214;
              if ($opEqualY(option,"2")) {
                $line=215;
                if ($opSbsetY(Utilities.toSet(stringOut),inputD)) {
                  $line=216;
                  result=$fix(((gold.structures.automaton.ITransducer)D).acceptsString($cast(java.lang.String.class,stringOut)));
                  $line=217;
                  System.out.println($message(new Object[]{$opAdditY($opAdditY($opAdditY("The coded string was ",(($bool(result))?("accepted"):("not accepted"))),". Output: "),((gold.structures.automaton.ITransducer)D).getOutputString())}));
                  $line=218;
                  Object stringOut1=$fix(((gold.structures.automaton.ITransducer)D).getOutputString());
                  $line=219;
                  System.out.println($message(new Object[]{$opAdditY($opAdditY("The decoded string is ",((!$opEqualY(stringOut1,string))?("not "):(""))),"equal to the original string.")}));
                }
                else {
                  $line=221;
                  System.out.println($message(new Object[]{$opAdditY("Output contains invalid symbols for the decoder: ",$opDiffeY(Utilities.toSet(stringOut),inputD))}));
                }
              }
            }
            else {
              $line=226;
              System.out.println($message(new Object[]{$opAdditY("Input contains invalid symbols: ",$opDiffeY(Utilities.toSet(string),inputC))}));
            }
          }
          else {
            $line=229;
            if ($opSbsetY(Utilities.toSet(string),inputD)) {
              $line=230;
              Object result=$fix(((gold.structures.automaton.ITransducer)D).acceptsString($cast(java.lang.String.class,string)));
              $line=231;
              System.out.println($message(new Object[]{$opAdditY($opAdditY($opAdditY("The string was ",(($bool(result))?("accepted"):("not accepted")))," by the decoder. Output: "),((gold.structures.automaton.ITransducer)D).getOutputString())}));
            }
            else {
              $line=233;
              System.out.println($message(new Object[]{$opAdditY("Input contains invalid symbols: ",$opDiffeY(Utilities.toSet(string),inputD))}));
            }
          }
        }
      }
      $line=240;
      System.out.println($message(new Object[]{"Execution Ended"}));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Utilities.class,"testCodeDecode",$line);
    }
    return $result;
  }
}
