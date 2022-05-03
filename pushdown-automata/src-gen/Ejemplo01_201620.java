// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/Ejemplo01_201620.gold"
import gold.structures.automaton.*;
import gold.util.*;
import gold.visualization.automaton.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class Ejemplo01_201620 {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=4;
      GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,Ejemplo01_201620.createAutomaton()));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Ejemplo01_201620.class,"main",$line);
    }
  }
  public static IPushdownAutomaton createAutomaton() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=16;
      Object Q=$fix(GCollections.asSet("s","q","f"));
      $line=17;
      Object \u03A3=$fix(GCollections.asSet('a','b','c','d'));
      $line=18;
      Object \u0393=$fix(GCollections.asSet('$','a','b','c','d','S','B'));
      $line=19;
      Object q_0=$fix("s");
      $line=20;
      Object F=$fix(GCollections.asSet("f"));
      $line=21;
      Object M=$fix($invokeConstructor(GPushdownAutomaton.class,new Object[]{Q,\u03A3,\u0393,q_0,F}));
      $line=22;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("s","q",$cast(java.lang.String.class,"")),new Object[]{"$S"});
      $line=23;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","f",$cast(java.lang.String.class,"")),new Object[]{"$"});
      $line=24;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"a")),new Object[]{"a"});
      $line=25;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"c")),new Object[]{"c"});
      $line=26;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"b")),new Object[]{"b"});
      $line=27;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"d")),new Object[]{"d"});
      $line=28;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"B"});
      $line=29;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"B","ddBc"});
      $line=30;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"S","B"});
      $line=31;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"S","bSaa"});
      $line=34;
      $result=M;
      if (true) break $try;
      $line=35;
      $rethrow(new RuntimeException("The function \"createAutomaton()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Ejemplo01_201620.class,"createAutomaton",$line);
    }
    return $cast(IPushdownAutomaton.class,$result);
  }
}
