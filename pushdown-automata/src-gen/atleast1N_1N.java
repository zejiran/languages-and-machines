// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/atleast1N_1N.gold"
import gold.structures.automaton.*;
import gold.util.*;
import gold.visualization.automaton.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class atleast1N_1N {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=15;
      GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,atleast1N_1N.createAutomaton()));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,atleast1N_1N.class,"main",$line);
    }
  }
  public static IPushdownAutomaton createAutomaton() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=18;
      Object \u03A3=$fix(GCollections.asSet('1','$'));
      $line=21;
      Object Q=$fix($opIntvlY(1,7));
      $line=23;
      Object \u0393=$fix(GCollections.asSet('1','$'));
      $line=24;
      Object q_0=$fix(1);
      $line=25;
      Object F=$fix(GCollections.asSet(6,7));
      $line=26;
      Object M=$fix($invokeConstructor(GPushdownAutomaton.class,new Object[]{Q,\u03A3,\u0393,q_0,F}));
      $line=28;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta(1,2,$cast(java.lang.String.class,"1")),new Object[]{"$"});
      $line=29;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta(1,3,$cast(java.lang.String.class,"1")),new Object[]{"$1"});
      $line=31;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta(2,2,$cast(java.lang.String.class,"1")),new Object[]{});
      $line=32;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta(2,2,$cast(java.lang.String.class,"$1")),new Object[]{});
      $line=33;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta(2,3,$cast(java.lang.String.class,"$1")),new Object[]{"1"});
      $line=36;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta(3,3,$cast(java.lang.String.class,"1")),new Object[]{"1"});
      $line=37;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta(3,4,$cast(java.lang.String.class,"$1")),new Object[]{});
      $line=38;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta(3,5,$cast(java.lang.String.class,"$")),new Object[]{});
      $line=41;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta(4,4,$cast(java.lang.String.class,"1")),new Object[]{});
      $line=42;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta(4,4,$cast(java.lang.String.class,"$1")),new Object[]{});
      $line=43;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta(4,5,$cast(java.lang.String.class,"$")),new Object[]{});
      $line=45;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta(5,5,$cast(java.lang.String.class,"1")),new Object[]{"1"});
      $line=46;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta(5,7,$cast(java.lang.String.class,"")),new Object[]{"$"});
      $line=47;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta(5,6,$cast(java.lang.String.class,"$1")),new Object[]{"$"});
      $line=49;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta(6,6,$cast(java.lang.String.class,"1")),new Object[]{});
      $line=50;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta(6,6,$cast(java.lang.String.class,"$1")),new Object[]{});
      $line=54;
      $result=M;
      if (true) break $try;
      $line=55;
      $rethrow(new RuntimeException("The function \"createAutomaton()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,atleast1N_1N.class,"createAutomaton",$line);
    }
    return $cast(IPushdownAutomaton.class,$result);
  }
}