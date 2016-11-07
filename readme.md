## HanziToPinyin

#### [Combination of output format options](http://pinyin4j.sourceforge.net/html/combination.html)
Three types of output format options can be customized in [pinyin4j](http://pinyin4j.sourceforge.net/). 

- VCharType: output format of character 'ü', which has three options. 
    - WITH_U_AND_COLON (default)
    - WITH_V
    - WITH_U_UNICODE
- ToneType: output format of Chinese tones, which has three options. 
    - WITH_TONE_NUMBER (default)
    - WITHOUT_TONE
    - WITH_TONE_MARK
- CaseType: cases of letters in outputted string, which has two options. 
    - LOWERCASE (default)
    - UPPERCASE

Some combinations of these three output formats are forbidden. For example, '吕' 

<table>
    <tr>
        <th colspan="4" align="center">LOWERCASE</th>
    </tr>
    <tr>
        <td>Combination</td>
        <td>WITH_U_AND_COLON</td>
        <td>WITH_V</td>
        <td>WITH_U_UNICODE</td>
    </tr>
    <tr>
        <td>WITH_TONE_NUMBER</td>
        <td>lu:3</td>
        <td>lv3</td>
        <td>l&#252;3</td>
    </tr>
    <tr>
        <td>WITHOUT_TONE</td>
        <td>lu:</td>
        <td>lv</td>
        <td>l&#252;</td>
    </tr>
    <tr>
        <td>WITH_TONE_MARK</td>
        <td>Exception</td>
        <td>Exception</td>
        <td>l&#474;</td>
    </tr>
</table>

<table>
    <tr>
        <th colspan="4" align="center">UPPERCASE</th>
    </tr>
    <tr>
        <td>Combination</td>
        <td>WITH_U_AND_COLON</td>
        <td>WITH_V</td>
        <td>WITH_U_UNICODE</td>
    </tr>
    <tr>
        <td>WITH_TONE_NUMBER</td>
        <td>LU:3</td>
        <td>LV3</td>
        <td>L&#220;3</td>
    </tr>
    <tr>
        <td>WITHOUT_TONE</td>
        <td>LU:</td>
        <td>LV</td>
        <td>L&#220;</td>
    </tr>
    <tr>
        <td>WITH_TONE_MARK</td>
        <td>Exception</td>
        <td>Exception</td>
        <td>L&#473;</td>
    </tr>
</table>

#### [Numerals in place of tone marks](https://en.wikipedia.org/wiki/Pinyin)

|Tone|Tone Mark|Number added to end of syllable <br/>in place of tone mark|Example using <br/>tone mark|Example using <br/>number|
|----|----|----|----|----|
|First|macron (&#175;)|1|m&#257;|ma1|
|Second|acute accent (&#180;)|2|m&#225;|ma2|
|Third|caron (&#711;)|3|m&#462;|ma3|
|Fourth|grave accent (&#96;)|4|m&#224;|ma4|

## Links:

**[Combination of output format options](http://pinyin4j.sourceforge.net/html/combination.html)**

**[Unicode&reg; character table](http://unicode-table.com/en/#control-character)**

**[Pinyin](https://en.wikipedia.org/wiki/Pinyin)**

**[pinyin4j](http://pinyin4j.sourceforge.net/)**