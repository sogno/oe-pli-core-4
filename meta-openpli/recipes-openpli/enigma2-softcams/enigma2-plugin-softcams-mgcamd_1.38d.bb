DESCRIPTION = "mgcamd ${PV} softcam"

PR = "r12"

SRC_URI = "http://pluginvalley.kr/sources/mgcamd${PV}.zip"

CAMNAME = "mgcamd"

S = "${WORKDIR}/mgcamd${PV}"

CAMSTART = "sleep 3 ; start-stop-daemon -S -b -x /usr/bin/${CAMNAME}"

require softcam.inc

INHIBIT_PACKAGE_STRIP = "1"

do_install() {
	install -d ${D}/usr/lib
	install -m 0644 ${S}/libcrypto.so.0.9.7 ${D}/usr/lib/libcrypto.so.0.9.7
	
	install -d ${D}/usr/bin
	install -m 0755 ${S}/mgcamd.mips ${D}/usr/bin/mgcamd
	
	install -d ${D}/usr/keys
	install -m 0644 ${S}/mg_cfg ${D}/usr/keys/mg_cfg
	install -m 0644 ${S}/newcamd.list ${D}/usr/keys/newcamd.list
	install -m 0644 ${S}/cccamd.list ${D}/usr/keys/cccamd.list
	install -m 0644 ${S}/priority.list ${D}/usr/keys/priority.list
	install -m 0644 ${S}/replace.list ${D}/usr/keys/replace.list
	install -m 0644 ${S}/peer.cfg ${D}/usr/keys/peer.cfg
	install -m 0644 ${S}/SoftCam.Key ${D}/usr/keys/SoftCam.Key
}

FILES_${PN} += "/usr/keys"
FILES_${PN} += "/usr/lib"

SRC_URI[md5sum] = "45b966308036f19b71a8a7e27031738b"
SRC_URI[sha256sum] = "a02a1fff48d44b792add20ac06c04e4fe9e03ab18e34fea5a5ea96dcb286b1a0"
