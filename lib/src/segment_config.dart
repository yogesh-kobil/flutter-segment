class SegmentConfig {
  SegmentConfig({
    required this.writeKey,
    required this.apiHost,
    this.trackApplicationLifecycleEvents = false,
    this.debug = false,
  });

  final String writeKey;
  final String apiHost;
  final bool trackApplicationLifecycleEvents;
  final bool debug;

  Map<String, dynamic> toMap() {
    return {
      'writeKey': writeKey,
      'apiHost': apiHost,
      'trackApplicationLifecycleEvents': trackApplicationLifecycleEvents,
      'debug': debug,
    };
  }
}
