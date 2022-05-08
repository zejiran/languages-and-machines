// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/maybeCatNoCat.gold"
import gold.structures.automaton.*;
import gold.util.*;
import gold.visualization.automaton.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class maybeCatNoCat {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=14;
      GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,maybeCatNoCat.createAutomaton()));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,maybeCatNoCat.class,"main",$line);
    }
  }
  public static IPushdownAutomaton createAutomaton() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=19;
      Object Q=$fix(GCollections.asSet("_cat","c_at","ca_t","cat","I"));
      $line=20;
      Object \u03A3=$fix(GCollections.asSet('c','a','t'));
      $line=21;
      Object \u0393=$fix(GCollections.asSet('1'));
      $line=22;
      Object q_0=$fix("I");
      $line=23;
      Object F=$fix($opDiffeY(Q,GCollections.asSet("cat")));
      $line=24;
      Object M=$fix($invokeConstructor(GPushdownAutomaton.class,new Object[]{Q,\u03A3,\u0393,q_0,F}));
      $line=26;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","I",$cast(java.lang.String.class,"a")),new Object[]{"1"});
      $line=27;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","I",$cast(java.lang.String.class,"c")),new Object[]{"1"});
      $line=28;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","I",$cast(java.lang.String.class,"t")),new Object[]{"1"});
      $line=30;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","_cat",$cast(java.lang.String.class,"")),new Object[]{});
      $line=32;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("_cat","c_at",$cast(java.lang.String.class,"c")),new Object[]{"1"});
      $line=33;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("_cat","_cat",$cast(java.lang.String.class,"a")),new Object[]{"1"});
      $line=34;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("_cat","_cat",$cast(java.lang.String.class,"t")),new Object[]{"1"});
      $line=36;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("c_at","c_at",$cast(java.lang.String.class,"c")),new Object[]{"1"});
      $line=37;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("c_at","ca_t",$cast(java.lang.String.class,"a")),new Object[]{"1"});
      $line=38;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("c_at","_cat",$cast(java.lang.String.class,"t")),new Object[]{"1"});
      $line=41;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("ca_t","c_at",$cast(java.lang.String.class,"c")),new Object[]{"1"});
      $line=42;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("ca_t","_cat",$cast(java.lang.String.class,"a")),new Object[]{"1"});
      $line=43;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta("ca_t","cat",$cast(java.lang.String.class,"t")),new Object[]{});
      $line=46;
      $result=M;
      if (true) break $try;
      $line=47;
      $rethrow(new RuntimeException("The function \"createAutomaton()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,maybeCatNoCat.class,"createAutomaton",$line);
    }
    return $cast(IPushdownAutomaton.class,$result);
  }
}