// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/halvesWithDifferent3symbols.gold"
import gold.structures.automaton.*;
import gold.util.*;
import gold.visualization.automaton.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class halvesWithDifferent3symbols {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=15;
      Object M=$fix($invokeConstructor(GDeterministicAutomaton.class,new Object[]{GCollections.asSet(0,1),$opIntvlY('a','b'),0,GCollections.asSet(0),new GMethod(halvesWithDifferent3symbols.class,"d")}));
      $line=16;
      GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,M));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,halvesWithDifferent3symbols.class,"main",$line);
    }
  }
  public static Object d(Object q, Object x) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=19;
      if ($opEqualY(x,'a')) {
        $line=19;
        $result=$opModulY($opAdditY(q,1),2);
        if (true) break $try;
      }
      else {
        $line=22;
        $result=q;
        if (true) break $try;
      }
      $line=26;
      $rethrow(new RuntimeException("The function \"d(q:Object,x:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,halvesWithDifferent3symbols.class,"d",$line);
    }
    return $result;
  }
}