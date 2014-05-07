KV = "3.9.7"
SRCDATE = "20140505"

RDEPENDS_${PN} += "sogno-mac-check"

SRC_URI[md5sum] = "eb8f75ca2d940eea06aada2de15e98c0"
SRC_URI[sha256sum] = "c74d1cd18a1b1b08eff8403f4f020ff2ac35f580d75b5ef6860ba5efaafaefb8"

SRC_URI = "http://pluginvalley.kr/bcm/driver/linuxdvb_7405-${KV}-${SRCDATE}.tar.gz"

require sogno-dvb-modules.inc
