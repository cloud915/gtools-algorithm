package com.gtools.algorithm.jvm;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JvmArgumentDictionary {
    private static Map<String, String> JvmDict = new HashMap<String, String>();
    public static final String UNKNOWN_ARGUMENT = "unknown arguement";
    public static final Pattern MEMORY_ARG_PATTERN = Pattern.compile("^(-X\\w{2})(\\d+\\w)");

    /**
     * 转义
     *
     * @param argument
     * @return
     */
    public static String translateArgument2Meaning(String argument) {
        if (StringUtils.isBlank(argument)) {
            return null;
        }
        final String key = argument.trim();
        if (!JvmDict.containsKey(key)) {
            Matcher matcher = MEMORY_ARG_PATTERN.matcher(argument);
            if (matcher.matches()) {
                String k = matcher.group(1);
                String v = matcher.group(2);
                if (JvmDict.containsKey(k)) {
                    return JvmDict.get(k) + "=" + v;
                }
            }
            return UNKNOWN_ARGUMENT;
            //return key;
        }
        return JvmDict.get(key);
    }

    static {
        // 1-内存相关
        JvmDict.put("-Xms", "初始堆大小");
        JvmDict.put("-Xmx", "最大堆大小");
        JvmDict.put("-Xmn", "年轻代大小，推荐整个堆的3/8。当前配置");
        JvmDict.put("-XX:MetaspaceSize", "元空间大小");
        JvmDict.put("-XX:newSize", "新生代初始内存的大小，应该小于初始堆(-Xms)的值");
        JvmDict.put("-XX:NewRatio", "年轻代与年老代的比值。如果为3，代表1:3，年轻代占整个（年轻代+老年代）的1/4");
        JvmDict.put("-XX:MaxNewSize", "新生代最大值");
        JvmDict.put("-XX:PermSize", "持久代(perm gen)初始值");
        JvmDict.put("-XX:MaxPermSize", "持久代最大值");
        JvmDict.put("-Xss", "每个线程的堆栈大小");
        JvmDict.put("-XX:SurvivorRatio", "Survivor和Eden区的大小比例，设置8代表两个Survivor区和一个Eden区的比值为2:8，对象在Eden创建");
        JvmDict.put("-XX:+DisableExplicitGC", "关闭System.gc()");
        JvmDict.put("-XX:MaxTenuringThreshold", "设置垃圾最大年龄，默认15。为0则gc时直接进入老年代。如果设置较大，可以提升对象在年轻代存货时间，增加YGC被回收概率");
        JvmDict.put("-XX:PretenureSizeThreshold", "对象超过多大是直接在老年代分配，单位字节，新生代采用Parallel Scavenge GC时无效；另一种直接在旧生代分配的情况是大的数组对象,且数组中无外部引用对象");
        JvmDict.put("-XX:UseBiasedLocking", "锁机制的性能改善，有偏见的锁是使得锁更偏爱上次使用到它线程。在非竞争锁的场景下，即只有一个线程会锁定对象，可以实现近乎无锁的开销");
        JvmDict.put("-Xnoclassgc", "禁用类垃圾回收");
        JvmDict.put("-XX:SoftRefLRUPolicyMSPerMB", "每兆堆空闲空间中SoftReference的存活时间，默认是1s");
        JvmDict.put("-XX:+CollectGen0First", "FullGC时是否先YGC，默认false");
        JvmDict.put("-XX:+AggressiveOpts", "加快编译");
        JvmDict.put("-XX:+UseFastAccessorMethods", "原始类型的快速优化 1.7以后不建议使用，1.6之前默认打开的");
        JvmDict.put("-XX:+UseFastEmptyMethods", "优化空方法，1.7以后不建议使用，1.6之前默认打开的");
        JvmDict.put("-XX:LargePageSizeInBytes", "内存页的大小。不可设置过大，会影响Perm的大小，基本没用过");

        // 2-收集器相关
        JvmDict.put("-server", "启用-server时新生代默认采用并行收集，其他情况下，默认不启用。-server策略为：新生代使用并行清除，年老代使用单线程Mark-Sweep-Compact的垃圾收集器。");
        JvmDict.put("-XX:+UseParNewGC", "年轻代收集器");
        JvmDict.put("-XX:+UseParalleIGC", "年轻代、并行收集器，会StopWorld");
        JvmDict.put("-XX:ParallelGCThreads", "ParallelGC的线程数,设置垃圾收集器在并行阶段使用的线程数[一般设置为本机CPU线程数相等，即本机同时可以处理的个数，设置过大也没有用]");
        JvmDict.put("-XX:ConcGCThreads", "并发垃圾收集器使用的线程数量");
        JvmDict.put("-XX:+UseParalleIOldGC", "老年代、并行收集器");
        JvmDict.put("-XX:+UseAdaptiveSizePolicy", "设置此选项后,并行收集器会自动选择年轻代区大小和相应的Survivor区比例,以达到目标系统规定的最低相应时间或者收集频率等,此值建议使用并行收集器时,一直打开.");
        JvmDict.put("-XX:+UseG1GC", "G1收集器");
        JvmDict.put("-XX:MaxGCPauseMillis", "每次年轻代gc的最长时间（最大暂停时间）");
        JvmDict.put("-XX:GCTimeRatio", "设置垃圾回收时间占程序运行时间的，百分比公式为1/(1+n)");
        JvmDict.put("-XX:+ScavengeBeforeFullGC", "Full GC前调用YGC，默认true");

        // cms相关
        JvmDict.put("-XX:+UseConcMarkSweepGC", "使用CMS内存收集，只能与年轻代的-XX:+UseParNewGC配合使用");
        JvmDict.put("-XX:CMSInitiatingOccupancyFraction", "使用cms作为垃圾回收，当堆内存达到xx％后开始CMS收集,value为1-100");// 整个堆的比例
        JvmDict.put("-XX:CMSInitiatingPermOccupancyFraction", "设置老年代（Perm Gen）使用到达多少比率时触发");// 老年代使用比例
        JvmDict.put("-XX:MinHeapFreeRatio", "java堆中空闲量占的最小比例");
        JvmDict.put("-XX:CMSTriggerRatio", "CMSInitiatingOccupancyFraction = (100 - MinHeapFreeRatio) + (CMSTriggerRatio * MinHeapFreeRatio / 100) 触发cms收集的比例");
        JvmDict.put("-XX:+CMSPermGenSweepingEnabled", "为了避免Perm区满引起的Full GC，开启并发收集器回收Perm区选项");
        JvmDict.put("-XX:+CMSClassUnloadingEnabled", "年老代启用CMS，但默认是不会回收永久代(Perm)的。如果你设置了该参数，垃圾回收会清理持久代，移除不再使用的classes。这个参数只有在 UseConcMarkSweepGC 也启用的情况下才有用。需要与+CMSPermGenSweepingEnabled同时启用");
        JvmDict.put("-XX:+CMSIncrementalMode", "设置为增量模式");
        JvmDict.put("-XX:CMSFullGCsBeforeCompaction", "由于并发收集器不对内存空间进行压缩、整理,所以运行一段时间以后会产生'碎片',使得运行效率降低.此值设置运行多少次GC以后对内存空间进行压缩,整理");
        JvmDict.put("-XX:+CMSParallelRemarkEnabled", "降低CMS标记停顿");
        JvmDict.put("-XX:+UseCMSCompactAtFullCollection", "在FULL GC的时候，对年老代的压缩，CMS是不会移动内存的，因此，这个非常容易产生碎片，导致内存不够用，因此，内存的压缩这个时候就会被启用。 增加这个参数是个好习惯。可能会影响性能,但是可以消除碎片");

        JvmDict.put("-XX:+UseCMSInitiatingOccupancyOnly", "使用手动定义的比例，触发CMS收集，禁止hostspot自行触发CMS GC；与-XX:CMSInitiatingOccupancyFraction=70配合使用");
        JvmDict.put("-XX:+AggressiveHeap", "试图是使用大量的物理内存长时间大内存使用的优化，能检查计算资源（内存， 处理器数量）至少需要256MB内存大量的CPU／内存，（在1.4.1在4CPU的机器上已经显示有提升）");

        // 3-辅助信息
        JvmDict.put("-XX:+PrintGC", "打印每次gc的情况，格式：[GC 118250K->113543K(130112K), 0.0094143 secs]Full GC 121376K->10414K(130112K), 0.0650971 secs]");
        JvmDict.put("-XX:+PrintGCDetails", "打印每次gc的详细情况");
        JvmDict.put("-XX:+PrintGCTimeStamps", "打印每次gc的时间戳");
        JvmDict.put("-XX:+PrintGCApplicationStoppedTime", "打印垃圾回收期间程序暂停的时间.可与上面混合使用");
        JvmDict.put("-XX:+PrintGCApplicationConcurrentTime", "打印每次垃圾回收前,程序未中断的执行时间.可与上面混合使用");
        JvmDict.put("-XX:+PrintHeapAtGC", "打印GC前后的详细堆栈信息");
        JvmDict.put("-Xloggc:filename", "把相关日志信息记录到文件以便分析.与上面几个配合使用");
        JvmDict.put("-XX:+PrintClassHistogram", "遇到Ctrl-Break后打印类实例的柱状信息，与jmap -histo功能相同");
        JvmDict.put("-XX:+PrintTenuringDistribution", "打印每次minor GC后新的存活周期的阈值");
        JvmDict.put("-XX:PrintHeapAtGC", "打印GC前后的详细堆栈信息");

        // 4-关键
        JvmDict.put("-XX:+HeapDumpOnOutOfMemoryError", "OOM时导出堆到文件");
        JvmDict.put("-XX:HeapDumpPath", "导出OOM的路径");
        JvmDict.put("-XX:TraceClassLoading", "监控类的加载");
        JvmDict.put("-XX:PrintClassHistogram", "按下Ctrl+Break后，打印类的信息");
        JvmDict.put("-XX:ErrorFile", "jvm崩溃日志的位置");
        JvmDict.put("-Xloggc", "指定GC log的位置，以文件输出");
        // Full gc
        JvmDict.put("-XX:+ExplicitGCInvokesConcurrent", "指定System.gc()采用cms算法，降低耗时。Full gc默认是调用MSC。这个参数是配合CMS使用的，开启后System.gc()还是会触发Full GC，不过并不是一个完全的stop-the-world的Full GC，而是并发的CMS GC，并且不止针对老年代。");
        JvmDict.put("-XX:+CMSScavengeBeforeRemark", "在cms的remark阶段之前，触发一次YGC");
        // 5-其他
        JvmDict.put("-XX:+UnlockExperimentalVMOptions", "解锁任何额外的隐藏参数；比如要使用某些参数的时候，可能不会生效，需要设置这个参数来解锁");

    }
}
