KV = "3.9.7"
SRCDATE = "20140212"

RDEPENDS_${PN} += "sogno-mac-check"

SRC_URI[md5sum] = "b93bbc3b3d43e93220ba10d745229be1"
SRC_URI[sha256sum] = "8b7ebe813f85528fcd2e7553c7f2493b485e0567061c5abdd2d36bee805061fa"

SRC_URI = "http://pluginvalley.kr/bcm/driver/sogno8800hd-drivers-${KV}-${SRCDATE}.zip"

require sogno-dvb-modules.inc
