// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/PartsOf.gold"
import gold.structures.automaton.*;
import gold.structures.set.*;
import gold.util.*;
import gold.visualization.automaton.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class PartsOf {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=17;
      Object A=$fix($opIntvlY('a','g'));
      $line=24;
      Object Q=$fix($opUnionY($opCartsY(new Object[]{$opPwsetY(A),GCollections.asSet(0,1)}),GCollections.asSet("err")));
      $line=28;
      Object \u03A3=$fix($opUnionY(A,GCollections.asSet('$')));
      $line=29;
      Object q_0=$fix(GCollections.asList(GCollections.emptySet(),0));
      $line=30;
      Object F=$fix($opCartsY(new Object[]{$opPwsetY(A),GCollections.asSet(1)}));
      $line=32;
      Object M=$fix($invokeConstructor(GDeterministicAutomaton.class,new Object[]{Q,\u03A3,q_0,F,new GMethod(PartsOf.class,"d")}));
      $line=37;
      if ($bool((!$opEqualY($invokeField("length",args),0)&&$opEqualY(((java.lang.String[])args)[$int(0)],"GUI")))) {
        $line=38;
        GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,M));
      }
      else {
        $line=40;
        Utilities.test($cast(gold.structures.automaton.IAutomaton.class,M));
      }
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,PartsOf.class,"main",$line);
    }
  }
  public static Object d(Object q, Object x) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=45;
      $result=q;
      if (true) break $try;
      $line=46;
      $rethrow(new RuntimeException("The function \"d(q:Object,x:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,PartsOf.class,"d",$line);
    }
    return $result;
  }
  public static Object d(java.lang.Iterable $v1, Object x) {
    int $line=0;
    Object $result=null;
    $try:try {
      java.util.Iterator $v2=GCollections.unmodifiableCollection($v1).iterator();
      Object S=$v2.next();
      Object q=$v2.next();
      $line=49;
      if (($opEqualY(q,0)&&!$opEqualY(x,'$'))) {
        $line=49;
        $result=GCollections.asList($opUnionY(S,GCollections.asSet(x)),q);
        if (true) break $try;
      }
      else {
        $line=53;
        if ($opEqualY(q,0)) {
          $line=53;
          $result=GCollections.asList(S,1);
          if (true) break $try;
        }
        else {
          $line=54;
          if ((($opEqualY(q,1)&&!$opMembrY(x,S))&&!$opEqualY(x,'$'))) {
            $line=54;
            $result=GCollections.asList(S,q);
            if (true) break $try;
          }
          else {
            $line=56;
            $result="err";
            if (true) break $try;
          }
        }
      }
      $line=58;
      $rethrow(new RuntimeException("The function \"d(\u27E8S,q\u27E9:java.lang.Iterable,x:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,PartsOf.class,"d",$line);
    }
    return $result;
  }
}