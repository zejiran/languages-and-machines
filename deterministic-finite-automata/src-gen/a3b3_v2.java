// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/a3b3_v2.gold"
import gold.structures.automaton.*;
import gold.util.*;
import gold.visualization.automaton.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class a3b3_v2 {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=11;
      Object Q=$fix($opUnionY($opCartsY(new Object[]{GCollections.asSet(0,1,2),$opIntvlY(0,2)}),GCollections.asSet(0,1,2,"E")));
      $line=12;
      Object \u03A3=$fix(GCollections.asSet('a','b','x'));
      $line=13;
      gold.structures.set.ISet $v1=$newSet();
      $v2:for (Object s:GCollections.unmodifiableCollection($opIntvlY(0,2))) {
        $v1.add(GCollections.asList(s,s));
      }
      Object F=$fix($v1);
      $line=14;
      Object M=$fix($invokeConstructor(GDeterministicAutomaton.class,new Object[]{Q,\u03A3,0,F,new GMethod(a3b3_v2.class,"d")}));
      $line=15;
      GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,M));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,a3b3_v2.class,"main",$line);
    }
  }
  public static Object d(Object q, Object s) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=19;
      if ($opEqualY(q,"E")) {
        $line=19;
        $result=q;
        if (true) break $try;
      }
      else {
        $line=20;
        if ($opEqualY(s,'a')) {
          $line=21;
          $result=$opModulY($opAdditY(q,1),3);
          if (true) break $try;
        }
        else {
          $line=22;
          if ($opEqualY(s,'b')) {
            $line=23;
            $result=q;
            if (true) break $try;
          }
          else {
            $line=25;
            $result=GCollections.asList(q,0);
            if (true) break $try;
          }
        }
      }
      $line=27;
      $rethrow(new RuntimeException("The function \"d(q:Object,s:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,a3b3_v2.class,"d",$line);
    }
    return $result;
  }
  public static Object d(java.lang.Iterable $v3, Object s) {
    int $line=0;
    Object $result=null;
    $try:try {
      java.util.Iterator $v4=GCollections.unmodifiableCollection($v3).iterator();
      Object a=$v4.next();
      Object c=$v4.next();
      $line=30;
      if ($opEqualY(s,'a')) {
        $line=31;
        $result=GCollections.asList(a,c);
        if (true) break $try;
      }
      else {
        $line=32;
        if ($opEqualY(s,'b')) {
          $line=33;
          $result=GCollections.asList(a,$opModulY($opAdditY(c,1),3));
          if (true) break $try;
        }
        else {
          $line=35;
          $result="E";
          if (true) break $try;
        }
      }
      $line=37;
      $rethrow(new RuntimeException("The function \"d(\u27E8a,c\u27E9:java.lang.Iterable,s:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,a3b3_v2.class,"d",$line);
    }
    return $result;
  }
}