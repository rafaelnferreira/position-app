package cfg

fields {
  field(name = "CONNECTION_NAME", type = STRING, nullable = false)
  field(name = "SENDER_ID", type = STRING)
  field(name = "TARGET_ID", type = STRING)
  field(name = "CL_ORD_ID", type = STRING)
  field(name = "ORIG_CL_ORD_ID", type = STRING)
  field(name = "FIX_DATA", type = STRING, maxSize = dbMaxSize())
  field(name = "RX_SEQUENCE", type = LONG)
  field(name = "SIZE", type = INT)
  field(name = "SEQUENCE", type = INT)
  field(name = "CONNECTION_STATUS", type = STRING)
  field(name = "SEQUENCE_NO", type = LONG)
  field(name = "PROCESS_NAME", type = STRING)
  field(name = "INTERNAL_TARGET", type = STRING)
  field(name = "HEAD_KEY", type = STRING)
  field(name = "SESSION_ID", type = STRING)
  field(name = "MESSAGE_SEQ_NUM", type = INT)
  field(name = "MESSAGE", type = STRING)
  field(name = "SENDER_SEQ_NUM", type = INT)
  field(name = "TARGET_SEQ_NUM", type = INT)
  field(name = "CREATION_TIME", type = LONG)
  field(name = "MESSAGE_PART_SEQUENCE", type = INT)
  // Fields for DATABASE FIX_SESSION DYNAMIC MANAGEMENT.
  // FIX_VERSION becomes "beginString" for SessionID
  // Valid values are "FIX.4.0", "FIX.4.1", "FIX.4.2", "FIX.4.3", "FIX.4.4", "FIXT.1.1"
  field(name = "FIX_VERSION", type = STRING)
  field(name = "SENDER_SUB_ID", type = STRING, default = "", nullable = false)
  field(name = "TARGET_SUB_ID", type = STRING, default = "", nullable = false)
  field(name = "SENDER_LOCATION_ID", type = STRING, default = "", nullable = false)
  field(name = "TARGET_LOCATION_ID", type = STRING, default = "", nullable = false)
  field(name = "SESSION_QUALIFIER", type = STRING, default = "", nullable = false)
  field(name = "FIX_CONNECTION_TYPE", type = ENUM("INITIATOR", "ACCEPTOR", default = "INITIATOR"))
  field(name = "FIX_HOSTNAME", type = STRING, default = "0.0.0.0")
  field(name = "FIX_PORT", type = INT, nullable = false)
  field(name = "FIX_START_TIME", type = STRING, nullable = false)
  field(name = "FIX_END_TIME", type = STRING, nullable = false)
  field(name = "FIX_TIME_ZONE", type = STRING)
  field(name = "FIX_DATA_DICTIONARY", type = STRING)
  // Only used for initiators
  field(name = "FIX_HEARTBEAT_INTERVAL", type = INT, default = 30)
  field(name = "FIX_SESSION_ENABLED", type = BOOLEAN, default = false)
  field(name = "FIX_SESSION_TEMPLATE", type = STRING, nullable = false)
  field(name = "FIX_PASSWORD", type = STRING, maxSize = 255, sensitive = true)
  field(name = "ENABLED", type = BOOLEAN)
}
