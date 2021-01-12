
import jsrsasign from 'jsrsasign'
import jsrsasignUtil from 'jsrsasign-util'
// var rsu = require('jsrsasign-util');
// import fs from 'fs-extra'

// 密钥对生成 
//http://web.chacuo.net/netrsakeypair
//java 生成需要加上 -----BEGIN PUBLIC KEY-----和-----END PUBLIC KEY-----

// 公钥
let pubk =
    "-----BEGIN PUBLIC KEY-----\n" +
    "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDblel5BFNPG+HTSGJgGOBhNsv2\n" +
    "WOqwU7Dvxuj1A+nU3M3eXTLY/xFU7q9LyxG4yGiR3VvPgjaduiO2WGF2sZECpwf6\n" +
    "Hjh4aNJSCsukFrkfClZ2CvissHVhxXv/DJfH2AZycBcvcFxKrKbUbU9WH46o8F7K\n" +
    "AGruU0JkBTDaRAZMgQIDAQAB\n" +
    "-----END PUBLIC KEY-----";

// 私钥
let priK =
    "-----BEGIN PRIVATE KEY-----\n" +
    "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCigmHQH33yDj7xYtZolU6o8DMPSA9CwBZV2Shyv/6fz05yWoyNJWHVCc1HNusp/gzQ592no59BT/vQzEdekndHYBRIR8G9FiPvryMg+qdSCHaVKTXXR4FQCJvdSfMtMb9UdRyegTnG1szNZSJKIW6WHh5/X1dT5NUvkRiz//hSA1AffISPDyQdccnmItTPo33fNKXhEBOlW8S25/9ABSGw1T6cfD5NfzeAf87UXZU9+iW99ZCp6kTUO84mrxPGd53hqibFd2kYuO2Oqx+GVJljSduhK+SXra3c7vrNWogMy5XumgZ6ECCE4nIXXuaTg0h9e3hLCwsttem5epoRa0S3AgMBAAECggEAZqAl+xPYKoN6ll/PfS5FBYTjCdR85q99q2s/EvBScUOui6LJPd2MocfV3hI9gkBQgaDbpqE60jkbkmle7MdcEjQHuvmtzKZtvVCBw7Lm9XQoxtvGh5Q9gnhdTesEadcPt9tZXnPHM920akVi2SOxvZV5twBTmsRZKPfdfNa6T7eMRL5GLnWtfOIMPJyq8a6Qp1cvsZP/uyn4RWCZi8BcJSuClnahJ6P9zbBzQn9tx38TYyXEwouA9IEAAuZlyeLFG9OXl6lbmsS6/abSD03i9GDgfGrz6VrcYp0c21V2Jna9QUB5j5RxxsSxowZ2kjoGovYn9ELEqh10qI7415gbeQKBgQDMkxxubAwGzc6njDA+Dinnis3Jt2eT73cZqWKoYIDkUGJJR3BfJQkDjsFYySwKgVHnay7DjVUUaev95hdcfmEXlLOfTjMGe9RzB3ujsQT6Oaj7sojpJ+UBX2OXi03SU5AqewRWVl9WjenJ4Jcz5otSBqO1CBtnjvCRMtJvDvFc5QKBgQDLXELSwN4QRlS2pSIXGM4cONPnfv1DZpWaKglxpFDId5qEJlgo+W6ttuGLsX/Pz6KgsklCskbfBrToCUd6thTirw+b3TkrUdqaEmRHZdksdOz+mrV2Y/VljU1WgC5jErmQDrTwPVXwpcu91YffQbCCLTSdMwwWOFHFVEQKYj2dawKBgGPMRGtt1DQhhHXiAsrTGAg3g4qrKSFXCbAAHPvtEBPRTxFWg3A23f3ZT2MjyJNbYPxXIloNgXrS7WhQLgdWM8FQLoxBlszL7ekrtlo1iisTo+cdwoKTjrkrsqcEMzOuxj6jAoun2RydYHa2VKziBAdA6+3thYjwh1UeCOBa1s4tAoGANrr/6QSrPyoOhpFu2VR9tC6/KSCOPOORA8qofANDEpDN7x76vxxSY0JC9Xux8FXraOBSwzaDyGZfrctBh48Vk+SViNdDGZuP/8NPZb/NcR+O4P72M4S3eLtMwykAUv2pH1I19CotxPR6Hv8m8DkXrhFIhb5FVH2X1EnXfgvulT0CgYEAl6KZ87Myt1CSyrVlRefYbOhtUBVr4CQP8MSMJ4z4NfSMf6ccG9UZRR3rCTHtRvJ+mDjb7veZXSD6FI+oZbCN5moVdIcu/WXyPkPty9fq6VVv5YPMXLQi4oZGCVLxKw2m/A6tctfRx6KFRfHhNGLH/pgACfl3ut6dLby1aVVSejk=" +
    "-----END PRIVATE KEY-----";

// console.log("jsutil:"+jsrsasignUtil.readFileHexByBin("./pri.key"));
export function getkeys(){
    // var pem = fs.readFileSync('./server.keystore');
    var pem =  jsrsasignUtil.readFile('./server.keystore');
    // var pem =  loadFile('./server.keystore')
    var prvKey = jsrsasignUtil.KEYUTIL.getKey(pem, 'passwd');
    console.log(prvKey);
    // jsrsasignUtil.readFile();
}

const loadFile = function (name) { // name为文件所在位置
    let xhr = new XMLHttpRequest(),
        okStatus = document.location.protocol === "file:" ? 0 : 200;
    xhr.open('GET', name, false);
    xhr.overrideMimeType("text/html;charset=utf-8");//默认为utf-8
    xhr.send(null);
    return xhr.status === okStatus ? xhr.responseText : null;
}
export default loadFile;




// 私钥加签
export function signature(signData) {
    
    // 创建秘钥实例
    var key = jsrsasign.KEYUTIL.getKey(priK);
    // 指定签名算法 sha1对原文哈希
    let signature = new jsrsasign.KJUR.crypto.Signature({ alg: "SHA1withRSA" });
    // 传入秘钥实例, 初始化
    signature.init(key);
    // 传入待签明文
    signature.updateString(signData);
    // 签名, 得到16进制字符结果
    let signResult = signature.sign();
    // 签名hex转base64
    let signBase64 = jsrsasign.hextob64(signResult);
    // console.log(signBase64);
    return signBase64;
}


export function signaturePCK8(signData) {
    let signature = new jsrsasign.KJUR.crypto.Signature({ alg: "SHA1withRSA", prvkeypem: priK });    //!这里指定 私钥 pem!
    signature.updateString(signData);
    return jsrsasign.hextob64(signature.sign());
}

export function signaturePCK1(signData) {
    var key = jsrsasign.KEYUTIL.getKey(priK);
    console.log(key);
    let signature = new jsrsasign.KJUR.crypto.Signature({ alg: "SHA1withRSA" });
    // 传入key实例, 初始化signature实例
    signature.init(key);
    // 传入待签明文
    signature.updateString(signData);
    // 签名, 得到16进制字符结果
    let a = signature.sign();
    let sign = jsrsasign.hextob64(a);
    console.log(sign);
    return sign;
}


// 验签 用公钥对签名进行验签
export function verify(signData, data) {
    // signData: 加签的数据
    // data: 加签之后得到的签文
    try {
        // 验签
        // !要重新new 一个Signature, 否则, 取摘要和签名时取得摘要不一样, 导致验签误报失败(原因不明)!
        let signatureVf = new jsrsasign.KJUR.crypto.Signature({ alg: "SHA1withRSA", prvkeypem: pubk });
        signatureVf.updateString(data);
        // !接受的参数是16进制字符串!
        let result = signatureVf.verify(jsrsasign.b64tohex(signData));
        console.log("jsrsasign verify: " + result);
        return result;
    } catch (e) {
        console.error(e);
    }
}

// 加密
export function encrypt(encryptData) {
    // 读取解析pem格式的秘钥, 生成秘钥实例 (RSAKey) 
    var pub = jsrsasign.KEYUTIL.getKey(pubk);
    var enc = jsrsasign.KJUR.crypto.Cipher.encrypt(encryptData, pub);
    console.log("jsrsasign decrypt: " + enc);
    console.log("jsrsasign hextob64: " + jsrsasign.hextob64(enc));
    return jsrsasign.hextob64(enc);
}

// 解密
export function decrypt(decryptData) {
    var prv = jsrsasign.KEYUTIL.getKey(priK);
    var dec = jsrsasign.KJUR.crypto.Cipher.decrypt(jsrsasign.b64utohex(decryptData), prv);
    console.log("jsrsasign decrypt: " + dec);
    console.log("jsrsasign b64utohex: " + jsrsasign.b64utohex(dec));
    return dec;
}


